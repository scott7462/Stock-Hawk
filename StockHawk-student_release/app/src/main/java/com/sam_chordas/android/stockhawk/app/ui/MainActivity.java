package com.sam_chordas.android.stockhawk.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.base.BaseActivity;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventSnackbarMessage;
import com.sam_chordas.android.stockhawk.app.ui.home.HomeFragment;
import com.sam_chordas.android.stockhawk.app.utils.ConnectionUtils;
import com.sam_chordas.android.stockhawk.service.StockTaskService;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
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
public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    EventSnackbarMessage eventSnackbarMessage;
    private boolean screamWithToPages;

    public EventSnackbarMessage getEventSnackbarMessage() {
        return eventSnackbarMessage;
    }

    public void setEventSnackbarMessage(EventSnackbarMessage eventSnackbarMessage) {
        this.eventSnackbarMessage = eventSnackbarMessage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.container_detail) != null) {
            screamWithToPages = true;
        }
        if (savedInstanceState != null) {
            navigateMainContent(getSupportFragmentManager().getFragment(
                    savedInstanceState, "mContent"), getString(R.string.app_name));
        } else {
            navigateMainContent(HomeFragment.newInstance(), getString(R.string.app_name));
        }
        eventSnackbarMessage = new EventSnackbarMessage(getWindow().getDecorView().getRootView());
        if (ConnectionUtils.isOnline(this)) {
            long period = 3600L;
            long flex = 1L;
            String periodicTag = StockTaskService.CALLS.PERIODIC.toString();

            // create a periodic task to pull stocks once every hour after the app has been opened. This
            // is so Widget data stays up to date.
            PeriodicTask periodicTask = new PeriodicTask.Builder()
                    .setService(StockTaskService.class)
                    .setPeriod(period)
                    .setFlex(flex)
                    .setTag(periodicTag)
                    .setRequiredNetwork(Task.NETWORK_STATE_CONNECTED)
                    .setRequiresCharging(false)
                    .build();
            // Schedule task with tag "periodic." This ensure that only the stocks present in the DB
            // are updated.
            GcmNetworkManager.getInstance(this).schedule(periodicTask);
        }

    }

    @Subscribe
    public void onSnackbarMessageEvent(EventSnackbarMessage event) {
        handleSnackBarMessageEvent(event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", getSupportFragmentManager().findFragmentById(R.id.container));
    }

    public boolean isScreamWithToPages() {
        return screamWithToPages;
    }

}
