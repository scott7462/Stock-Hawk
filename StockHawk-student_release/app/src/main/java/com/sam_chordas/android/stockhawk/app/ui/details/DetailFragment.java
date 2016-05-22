package com.sam_chordas.android.stockhawk.app.ui.details;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.model.QuoteHistory;
import com.sam_chordas.android.stockhawk.app.retofit.Response.ResponseQuoteHistory;
import com.sam_chordas.android.stockhawk.app.utils.DateTimeUtils;

import org.joda.time.DateTime;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

/**
 * Copyright (C) 2015 The Android Open Source Project
 * <p/>
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
public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getSimpleName();
    @Bind(R.id.cBFrgDetail)
    LineChart cBFrgDetail;
    @Bind(R.id.eLFrgDetailsLoading)
    RelativeLayout eLFrgDetailsLoading;

    private Quote quote;
    private ArrayList<QuoteHistory> quotes = new ArrayList<QuoteHistory>();

    /**
     * Create a new Instance of the Fragment with the history quote form data.
     */
    public static Fragment newInstance(Quote quote) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Quote.QUOTE, quote);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVars();
    }

    private void initVars() {
        setHasOptionsMenu(true);
        if (getArguments() != null && getArguments().containsKey(Quote.QUOTE)) {
            quote = getArguments().getParcelable(Quote.QUOTE);
        }
        StringBuilder urlStringBuilder = new StringBuilder();
        urlStringBuilder.append(App.getGlobalContext().getString(R.string.url_basic_sql_query_to_service_history));
        urlStringBuilder.append("\"")
                .append(quote.getSymbol())
                .append("\") ")
                .append(getString(R.string.query_start_date))
                .append(DateTimeUtils.getStringPatternFromDateTime(getString(R.string.date_format_query), DateTime.now().minusMonths(12)))
                .append("\"")
                .append(getString(R.string.query_end_date))
                .append(DateTimeUtils.getStringPatternFromDateTime(getString(R.string.date_format_query), DateTime.now()))
                .append("\"");
        App.getRestClientPublic().getPublicService()
                .getQuoteHistory(urlStringBuilder.toString())
                .enqueue(new Callback<ResponseQuoteHistory>() {
                    @Override
                    public void onResponse(Response<ResponseQuoteHistory> response, Retrofit retrofit) {
                        if (eLFrgDetailsLoading != null) {
                            eLFrgDetailsLoading.setVisibility(View.GONE);
                            cBFrgDetail.invalidate();
                        }
                        quotes = response.body().getQuery().getResults().getQuote();
                        setData(45, 100);

                        Timber.e(TAG, response.toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Timber.e(TAG, t.toString());

                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        intViews();
        return view;
    }

    private void setData(int count, float range) {
        if (cBFrgDetail != null) {
            ArrayList<String> xVals = new ArrayList<String>();
            ArrayList<Entry> yVals = new ArrayList<Entry>();
            for (int i = 0; i < count; i++) {
                xVals.add(quotes.get(i).getDate());
                float val = Float.valueOf(quotes.get(i).getClose());
                yVals.add(new Entry(val, i));
            }
            LineDataSet set;

            if (cBFrgDetail.getData() != null &&
                    cBFrgDetail.getData().getDataSetCount() > 0) {
                set = (LineDataSet) cBFrgDetail.getData().getDataSetByIndex(0);
                cBFrgDetail.notifyDataSetChanged();
            } else {
                set = new LineDataSet(yVals, quote.getName());
                set.enableDashedLine(10f, 5f, 0f);
                set.enableDashedHighlightLine(10f, 5f, 0f);
                set.setColor(R.color.material_blue_700);
                set.setCircleColor(R.color.material_blue_500);
                set.setLineWidth(1f);
                set.setCircleRadius(3f);
                set.setDrawCircleHole(false);
                set.setValueTextSize(9f);
                set.setDrawFilled(true);
                set.setFillColor(R.color.material_green_700);


                ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                dataSets.add(set);
                LineData data = new LineData(xVals, dataSets);
                cBFrgDetail.setData(data);
                cBFrgDetail.invalidate();
            }
        }


    }


    private void intViews() {
        cBFrgDetail.setDrawGridBackground(false);
        cBFrgDetail.setDescription("");
        cBFrgDetail.setNoDataTextDescription(getString(R.string.frg_details_entry_data));
        cBFrgDetail.setBackgroundColor(Color.WHITE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                getActivity().onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
