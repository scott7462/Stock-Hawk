package com.sam_chordas.android.stockhawk.app.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.TaskParams;
import com.sam_chordas.android.stockhawk.app.model.Quote;

import timber.log.Timber;

/**
 * Created by sam_chordas on 10/1/15.
 */
public class StockIntentService extends IntentService {

    public StockIntentService() {
        super(StockIntentService.class.getName());
    }

    public StockIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Timber.d(StockIntentService.class.getSimpleName(), "Stock Intent Service");
        StockTaskService stockTaskService = new StockTaskService();
        Bundle args = new Bundle();
        if (intent.getStringExtra(StockTaskService.CALLS.TAG.toString()).equals(StockTaskService.CALLS.ADD.toString())) {
            args.putString(Quote.SYMBOL, intent.getStringExtra(Quote.SYMBOL));
        }
        stockTaskService.onRunTask(new TaskParams(intent.getStringExtra(StockTaskService.CALLS.TAG.toString()), args));
    }
}
