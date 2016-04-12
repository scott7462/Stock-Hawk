package com.sam_chordas.android.stockhawk.app.ui.adapter;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.utils.SettingsUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

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
public class AdapterQuote extends RecyclerView.Adapter<AdapterQuote.ViewHolder> {

    private static final String TAG = AdapterQuote.class.getSimpleName();
    ArrayList<Quote> items;

    public static boolean showPercent = true;

    public AdapterQuote(ArrayList<Quote> items) {
        this.items = items;
    }

    @Override
    public AdapterQuote.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterQuote.ViewHolder holder, final int position) {
        Quote quote = items.get(position);
        holder.tVStockSymbol.setText(quote.getSymbol());
        holder.tVBidPrice.setText(quote.getBid());
        int sdk = Build.VERSION.SDK_INT;
        if (quote.getChange().charAt(0) != '-') {
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                holder.tVChange.setBackgroundDrawable(
                        App.getGlobalContext().getResources().getDrawable(R.drawable.percent_change_pill_green));
            } else {
                holder.tVChange.setBackground(
                        App.getGlobalContext().getResources().getDrawable(R.drawable.percent_change_pill_green));
            }
        } else {
            if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
                holder.tVChange.setBackgroundDrawable(
                        App.getGlobalContext().getResources().getDrawable(R.drawable.percent_change_pill_red));
            } else {
                holder.tVChange.setBackground(
                        App.getGlobalContext().getResources().getDrawable(R.drawable.percent_change_pill_red));
            }
        }
        if (SettingsUtils.getPreferenceShowPercent()) {
            holder.tVChange.setText(quote.getPercentChange());
        } else {
            holder.tVChange.setText(quote.getChange());
        }
    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }


    public void setData(ArrayList<Quote> data) {
        this.items = data;
        notifyDataSetChanged();
    }

    public ArrayList<Quote> getItems() {
        return items;
    }

    public void updateShowPercent() {
        SettingsUtils.setPreferenceShowPercent(!SettingsUtils.getPreferenceShowPercent());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tVStockSymbol)
        TextView tVStockSymbol;
        @Bind(R.id.tVBidPrice)
        TextView tVBidPrice;
        @Bind(R.id.tVChange)
        TextView tVChange;


        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            tVStockSymbol.setTypeface(Typeface.createFromAsset(v.getContext().getAssets(),
                    "fonts/Roboto-Light.ttf"));
        }
    }
}
