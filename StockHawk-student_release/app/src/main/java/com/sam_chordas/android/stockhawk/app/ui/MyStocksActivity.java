package com.sam_chordas.android.stockhawk.app.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyStocksActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stocks);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (savedInstanceState != null) {
            navigateMainContent(getSupportFragmentManager().getFragment(
                    savedInstanceState, "mContent"), getString(R.string.app_name));
        } else {
            navigateMainContent(HomeFragment.newInstance(), getString(R.string.app_name));
        }

//
//                      Toast toast =
//                                                Toast.makeText(MyStocksActivity.this, "This stock is already saved!",
//                                                        Toast.LENGTH_LONG);
//                                        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//                                        fab.attachToRecyclerView(recyclerView);
//                                        fab.setOnClickListener(new View.OnClickListener() {
//                                            @Override
//                                            public void onClick(View v) {
//                                                if (isConnected) {
//                                                    new MaterialDialog.Builder(mContext).title(R.string.symbol_search)
//                                                            .content(R.string.content_test)
//                                                            .inputType(InputType.TYPE_CLASS_TEXT)
//                                                            .input(R.string.input_hint, R.string.input_prefill, new MaterialDialog.InputCallback() {
//                                                                @Override
//                                                                public void onInput(MaterialDialog dialog, CharSequence input) {
//                                                                    // On FAB click, receive user input. Make sure the stock doesn't already exist
//                                                                    // in the DB and proceed accordingly
//                                                                    Cursor c = getContentResolver().query(QuoteProvider.Quotes.CONTENT_URI,
//                                                                            new String[]{QuoteColumns.SYMBOL}, QuoteColumns.SYMBOL + "= ?",
//                                                                            new String[]{input.toString()}, null);
//                                                                    if (c.getCount() != 0) {
//                                                                        toast.setGravity(Gravity.CENTER, Gravity.CENTER, 0);
//                                        toast.show();
//                                        return;
//                                    } else {
//                                        // Add the stock to DB
//                                        mServiceIntent.putExtra("tag", "add");
//                                        mServiceIntent.putExtra("symbol", input.toString());
//                                        startService(mServiceIntent);
//                                    }
//                                }
//                            })
//                            .show();
//                } else {
//                    networkToast();
//                }

//            }
//        });
//
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mCursorAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(recyclerView);
//
//        mTitle = getTitle();
//        if (isConnected) {
//            long period = 3600L;
//            long flex = 10L;
//            String periodicTag = "periodic";
//
//            // create a periodic task to pull stocks once every hour after the app has been opened. This
//            // is so Widget data stays up to date.
//            PeriodicTask periodicTask = new PeriodicTask.Builder()
//                    .setService(StockTaskService.class)
//                    .setPeriod(period)
//                    .setFlex(flex)
//                    .setTag(periodicTag)
//                    .setRequiredNetwork(Task.NETWORK_STATE_CONNECTED)
//                    .setRequiresCharging(false)
//                    .build();
//            // Schedule task with tag "periodic." This ensure that only the stocks present in the DB
//            // are updated.
//            GcmNetworkManager.getInstance(this).schedule(periodicTask);
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "mContent", getSupportFragmentManager().findFragmentById(R.id.container));
    }

}
