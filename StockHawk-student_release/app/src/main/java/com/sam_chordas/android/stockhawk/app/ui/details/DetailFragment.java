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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
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
                .append("and startDate = \"")
                .append(DateTimeUtils.getStringPatternFromDateTime("YYYY-MM-dd", DateTime.now().minusMonths(12)))
                .append("\"")
                .append(" and endDate = \"")
                .append(DateTimeUtils.getStringPatternFromDateTime("YYYY-MM-dd", DateTime.now()))
                .append("\"");
        App.getRestClientPublic().getPublicService()
                .getQuoteHistory(urlStringBuilder.toString())
                .enqueue(new Callback<ResponseQuoteHistory>() {
                    @Override
                    public void onResponse(Response<ResponseQuoteHistory> response, Retrofit retrofit) {
//                        try {
//                            adapterDetail.setTrailers(response.body().getResults());
//                        } catch (NullPointerException e) {
//
//                        }
                        quotes = response.body().getQuery().getResults().getQuote();
                        setData();
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

    private void setData() {
        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < quotes.size(); i++) {
            xVals.add(quotes.get(i).getDate());
            float val = Float.valueOf(quotes.get(i).getClose());
            yVals.add(new Entry(val, i));
        }

        LineDataSet set;

        if (cBFrgDetail.getData() != null &&
                cBFrgDetail.getData().getDataSetCount() > 0) {
            set = (LineDataSet) cBFrgDetail.getData().getDataSetByIndex(0);
//            set.setYVals(yVals);
//            cBFrgDetail.getData().setXVals(xVals);
            cBFrgDetail.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set = new LineDataSet(yVals, "DataSet 1");

            // set1.setFillAlpha(110);
            // set1.setFillColor(Color.RED);

            // set the line to be drawn like this "- - - - - -"
            set.enableDashedLine(10f, 5f, 0f);
            set.enableDashedHighlightLine(10f, 5f, 0f);
            set.setColor(Color.BLACK);
            set.setCircleColor(Color.BLACK);
            set.setLineWidth(1f);
            set.setCircleRadius(3f);
            set.setDrawCircleHole(false);
            set.setValueTextSize(9f);
            set.setDrawFilled(true);

            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//                set.setFillDrawable(drawable);
            } else {
                set.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set); // add the datasets
            // create a data object with the datasets
            LineData data = new LineData(xVals, dataSets);
            // set data
            cBFrgDetail.setData(data);
            cBFrgDetail.invalidate();
        }


    }

    private void intViews() {
        cBFrgDetail.setDrawGridBackground(false);

        cBFrgDetail.setDescription("");
        cBFrgDetail.setNoDataTextDescription("You need to provide data for the chart.");

        cBFrgDetail.setBackgroundColor(Color.WHITE);

//        LimitLine llXAxis = new LimitLine(10f, "Index 10");
//        llXAxis.setLineWidth(4f);
//        llXAxis.enableDashedLine(10f, 10f, 0f);
//        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        llXAxis.setTextSize(10f);
//
//        XAxis xAxis = cBFrgDetail.getXAxis();
//        //xAxis.setValueFormatter(new MyCustomXAxisValueFormatter());
//        //xAxis.addLimitLine(llXAxis); // add x-axis limit line
//
//
//        LimitLine ll1 = new LimitLine(130f, "Upper Limit");
//        ll1.setLineWidth(4f);
//        ll1.enableDashedLine(10f, 10f, 0f);
//        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        ll1.setTextSize(10f);
//
//        LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
//        ll2.setLineWidth(4f);
//        ll2.enableDashedLine(10f, 10f, 0f);
//        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        ll2.setTextSize(10f);
//
//        YAxis leftAxis = cBFrgDetail.getAxisLeft();
//        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
//        leftAxis.addLimitLine(ll1);
//        leftAxis.addLimitLine(ll2);
//        leftAxis.setAxisMaxValue(220f);
//        leftAxis.setAxisMinValue(-50f);
//        //leftAxis.setYOffset(20f);
//        leftAxis.enableGridDashedLine(10f, 10f, 0f);
//        leftAxis.setDrawZeroLine(false);
//
//        // limit lines are drawn behind data (and not on top)
//        leftAxis.setDrawLimitLinesBehindData(true);
//
//        cBFrgDetail.getAxisRight().setEnabled(false);
//
//        //mChart.getViewPortHandler().setMaximumScaleY(2f);
//        //mChart.getViewPortHandler().setMaximumScaleX(2f);
//
//
////        mChart.setVisibleXRange(20);
////        mChart.setVisibleYRange(20f, AxisDependency.LEFT);
////        mChart.centerViewTo(20, 50, AxisDependency.LEFT);
//
//        cBFrgDetail.animateX(2500, Easing.EasingOption.EaseInOutQuart);
////        mChart.invalidate();
//
//        // get the legend (only possible after setting data)
//        Legend l = cBFrgDetail.getLegend();
//
//        // modify the legend ...
//        // l.setPosition(LegendPosition.LEFT_OF_CHART);
//        l.setForm(Legend.LegendForm.LINE);


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
