package com.sam_chordas.android.stockhawk.app.service;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.db.QuoteDaoAdapter;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuote;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import retrofit.Response;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by sam_chordas on 9/30/15.
 * The GCMTask service is primarily for periodic tasks. However, OnRunTask can be called directly
 * and is used for the initialization and adding task as well.
 */
public class StockTaskService extends GcmTaskService {

    private static final String TAG = StockTaskService.class.getSimpleName();
    private String LOG_TAG = StockTaskService.class.getSimpleName();
    private StringBuilder mStoredSymbols = new StringBuilder();
    private Subscription serviceSubscription;

    public enum CALLS {
        INIT("init"),
        PERIODIC("periodic"),
        ADD("add"),
        TAG("TAG");

        private final String text;

        /**
         * @param text
         */
        private CALLS(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public Subscription getServiceSubscription() {
        return serviceSubscription;
    }

    public void setServiceSubscription(Subscription serviceSubscription) {
        this.serviceSubscription = serviceSubscription;
    }

    @Override
    public int onRunTask(TaskParams params) {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        StringBuilder urlStringBuilder = new StringBuilder();
        urlStringBuilder.append(App.getGlobalContext().getString(R.string.url_basic_sql_query_to_service));
        if (params.getTag().equals(CALLS.INIT.toString()) || params.getTag().equals(CALLS.PERIODIC.toString())) {
            try {
                quotes = QuoteDaoAdapter.getAllQuote();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (quotes.size() == 0) {
                urlStringBuilder.append("\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");
            } else {
                for (Quote quote : quotes) {
                    mStoredSymbols.append("\"").append(quote.getSymbol()).append("\",");
                }
                mStoredSymbols.replace(mStoredSymbols.length() - 1, mStoredSymbols.length(), ")");
                urlStringBuilder.append(mStoredSymbols.toString());
            }

        } else if (params.getTag().equals(CALLS.ADD.toString())) {
            String stockInput = params.getExtras().getString("symbol");
            urlStringBuilder.append("\"").append(stockInput).append("\")");
        }
        int result = GcmNetworkManager.RESULT_FAILURE;
        if (urlStringBuilder != null) {
            try {
                Response<ResponseQuote> response = App.getRestClientPublic().getPublicService().getQuotes(urlStringBuilder.toString()).execute();
                if (response.isSuccess() && response.body() != null
                        && response.body().getResult() != null &&
                        response.body().getResult().getQuote() != null &&
                        response.body().getResult().getQuote().size() > 0) {
                    result = GcmNetworkManager.RESULT_SUCCESS;
                    for (Quote quote : response.body().getResult().getQuote()) {
                        QuoteDaoAdapter.insertQuote(quote);
                    }
                }
                Timber.d(TAG, response.toString());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
