package com.sam_chordas.android.stockhawk.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.base.BaseActivity;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventSnackBarMessage;
import com.sam_chordas.android.stockhawk.app.ui.home.HomeFragment;
import com.sam_chordas.android.stockhawk.app.utils.ConnectionUtils;
import com.sam_chordas.android.stockhawk.service.StockTaskService;
import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    EventSnackBarMessage eventSnackBarMessage;
    private boolean screamWithToPages;

    public EventSnackBarMessage getEventSnackBarMessage() {
        return eventSnackBarMessage;
    }

    public void setEventSnackBarMessage(EventSnackBarMessage eventSnackBarMessage) {
        this.eventSnackBarMessage = eventSnackBarMessage;
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
        eventSnackBarMessage = new EventSnackBarMessage(getWindow().getDecorView().getRootView());
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
    public void onSnackbarMessageEvent(EventSnackBarMessage event) {
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
