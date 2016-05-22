package com.sam_chordas.android.stockhawk.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.ui.MainActivity;
import com.sam_chordas.android.stockhawk.app.utils.SettingsUtils;
import com.sam_chordas.android.stockhawk.db.provider.Contract;

import java.util.ArrayList;
import java.util.List;

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
public class QuoteRemoteViewsFactory implements RemoteViewsFactory {
    private static final String TAG = QuoteRemoteViewsFactory.class.getSimpleName();
    private List<Quote> items = new ArrayList<Quote>();
    private Context mContext;
    private int mAppWidgetId;

    public QuoteRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    private void updateData() {
        items.clear();
        Cursor c = mContext.getContentResolver().query(Contract.Quote.contentUri, null, null, null, null);
        assert c != null;
        while (c.moveToNext()) {
            items.add(Quote.CursorQuote(c));
        }
        c.close();
    }

    public void onDestroy() {
        items.clear();
    }

    public int getCount() {
        return items.size();
    }

    public RemoteViews getViewAt(int position) {
        Quote quote = items.get(position);
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.widget_collection_item);
        rv.setTextViewText(R.id.tVStockSymbol, quote.getSymbol());
        rv.setTextViewText(R.id.tVBidPrice, items.get(position).getBid());
        if (quote.getChange() != null && quote.getChange().charAt(0) != '-') {
            rv.setInt(R.id.tVChange, "setBackgroundResource", R.drawable.percent_change_pill_green);
        } else {
            rv.setInt(R.id.tVChange, "setBackgroundResource", R.drawable.percent_change_pill_red);
        }
        if (SettingsUtils.getPreferenceShowPercent()) {
            rv.setTextViewText(R.id.tVChange, quote.getPercentChange());
        } else {
            rv.setTextViewText(R.id.tVChange, quote.getChange());
        }

        Intent clickIntentTemplate = new Intent(mContext, MainActivity.class);
//        PendingIntent clickPendingIntentTemplate = TaskStackBuilder.create(mContext)
//                .addNextIntentWithParentStack(clickIntentTemplate)
//                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        rv.setOnClickFillInIntent(R.id.lLWidget, clickIntentTemplate);
        return rv;
    }

    public RemoteViews getLoadingView() {
        return null;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public long getItemId(int position) {
        return position;
    }

    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void onCreate() {
        updateData();
    }

    public void onDataSetChanged() {
        updateData();
    }
}