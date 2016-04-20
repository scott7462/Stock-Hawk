package com.sam_chordas.android.stockhawk.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.App;

/**
 * Created by scott7462 on 4/19/16.
 */
public class WidgetUtils {

    public static void updateWidget() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(App.getGlobalContext());
        ComponentName thisWidget = new ComponentName(App.getGlobalContext(), QuoteWidgetProvider.class);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.listViewWidget);
    }
}
