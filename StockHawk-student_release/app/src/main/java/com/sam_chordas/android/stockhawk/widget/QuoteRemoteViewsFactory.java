package com.sam_chordas.android.stockhawk.widget;

import android.app.PendingIntent;
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
 * Created by android4 on 4/19/16.
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

        Intent intent = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
        rv.setOnClickPendingIntent(R.id.lLWidget, pendingIntent);
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