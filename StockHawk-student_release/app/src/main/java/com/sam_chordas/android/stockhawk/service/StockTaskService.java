package com.sam_chordas.android.stockhawk.service;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.busevents.BusProvider;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventUpdateData;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuote;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuotes;
import com.sam_chordas.android.stockhawk.app.utils.SettingsUtils;
import com.sam_chordas.android.stockhawk.db.QuoteDaoAdapter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import retrofit.Response;
import rx.Subscription;
import timber.log.Timber;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>8
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class StockTaskService extends GcmTaskService {

    private static final String TAG = StockTaskService.class.getSimpleName();
    private StringBuilder mStoredSymbols = new StringBuilder();
    private Subscription serviceSubscription;
    private boolean isUpdate = false;

    public enum CALLS {
        INIT("init"),
        PERIODIC("periodic"),
        ADD("add"),
        TAG("tag");

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
        int result = GcmNetworkManager.RESULT_FAILURE;
        StringBuilder urlStringBuilder = new StringBuilder();
        try {
            quotes = QuoteDaoAdapter.getAllQuote();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if ((params.getTag().equals(CALLS.INIT.toString()) || params.getTag().equals(CALLS.PERIODIC.toString())) &&
                quotes.size() != 1) {

            try {
                Response<ResponseQuotes> response = App.getRestClientPublic().getPublicService().getQuotes(bindQueryString(quotes).toString()).execute();
                if (response.isSuccess() && response.body() != null
                        && response.body().getQuery().getResults() != null &&
                        response.body().getQuery().getResults().getQuote() != null &&
                        response.body().getQuery().getResults().getQuote().size() > 0) {
                    if (isUpdate) {
                        QuoteDaoAdapter.removeAllQuote();
                    }

                    result = GcmNetworkManager.RESULT_SUCCESS;
                    for (Quote quote : response.body().getQuery().getResults().getQuote()) {
                        QuoteDaoAdapter.insertQuote(quote);
                    }
                }
                Timber.d(TAG, response.toString());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        } else if (params.getTag().equals(CALLS.ADD.toString())) {
            urlStringBuilder.append(App.getGlobalContext().getString(R.string.url_basic_sql_query_to_service));
            String stockInput = "";
            if (quotes.size() == 1) {
                stockInput = quotes.get(0).getSymbol();
            } else {

                stockInput = params.getExtras().getString(Quote.SYMBOL);
            }
            urlStringBuilder.append("\"").append(stockInput).append("\")");

            try {
                Response<ResponseQuote> response = App.getRestClientPublic().getPublicService().getQuote(urlStringBuilder.toString()).execute();
                if (response.isSuccess() && response.body() != null
                        && response.body().getQuery().getResults() != null &&
                        response.body().getQuery().getResults().getQuote() != null) {
                    if (response.body().getQuery().getResults().getQuote().getChange() != null) {
                        result = GcmNetworkManager.RESULT_SUCCESS;
                        QuoteDaoAdapter.insertQuote(response.body().getQuery().getResults().getQuote());
                    }

                }
                Timber.d(TAG, response.toString());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        BusProvider.getInstance().postOnNonUIThread(new EventUpdateData(result,params.getTag()));
        return result;
    }

    private StringBuilder bindQueryString(ArrayList<Quote> quotes) {
        StringBuilder urlStringBuilder = new StringBuilder();
        urlStringBuilder.append(App.getGlobalContext().getString(R.string.url_basic_sql_query_to_service));
        if (quotes.size() == 0 && !SettingsUtils.getPreferenceRemoveAll()) {
            urlStringBuilder.append("\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");
        } else if(quotes.size()>0){
            isUpdate = true;
            for (Quote quote : quotes) {
                mStoredSymbols.append("\"").append(quote.getSymbol()).append("\",");
            }
            mStoredSymbols.replace(mStoredSymbols.length() - 1, mStoredSymbols.length(), ")");
            urlStringBuilder.append(mStoredSymbols.toString());
        }

        return urlStringBuilder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }
}
