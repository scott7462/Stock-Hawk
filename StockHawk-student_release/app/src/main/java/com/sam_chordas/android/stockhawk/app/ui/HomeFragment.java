package com.sam_chordas.android.stockhawk.app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.busevents.BusProvider;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventSnackBarMessage;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventUpdateData;
import com.sam_chordas.android.stockhawk.app.model.Quote;
import com.sam_chordas.android.stockhawk.app.ui.adapter.AdapterQuote;
import com.sam_chordas.android.stockhawk.app.utils.ConnectionUtils;
import com.sam_chordas.android.stockhawk.db.QuoteDaoAdapter;
import com.sam_chordas.android.stockhawk.service.StockIntentService;
import com.sam_chordas.android.stockhawk.service.StockTaskService;
import com.squareup.otto.Subscribe;

import java.sql.SQLException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by android4 on 4/8/16.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private Intent mServiceIntent;
    private ItemTouchHelper mItemTouchHelper;
    private AdapterQuote mCursorAdapter;

    @Bind(R.id.rVHome)
    RecyclerView rVHome;

    @OnClick(R.id.fab)
    public void onClick() {
        if (ConnectionUtils.isOnline(getActivity())) {
            new MaterialDialog.Builder(getActivity()).title(R.string.symbol_search)
                    .content(R.string.content_test)
                    .inputType(InputType.TYPE_CLASS_TEXT)
                    .input(R.string.input_hint, R.string.input_prefill, new MaterialDialog.InputCallback() {
                        @Override
                        public void onInput(MaterialDialog dialog, CharSequence input) {
                            // On FAB click, receive user input. Make sure the stock doesn't already exist
                            // in the DB and proceed accordingly
                            try {
                                boolean quote = QuoteDaoAdapter.isQuote(input.toString());
                                if (quote) {
                                    BusProvider.getInstance().postOnUIThread(new EventSnackBarMessage("This stock is already saved!",getView()), getActivity());
                                    return;
                                } else {
                                    // Add the stock to DB
                                    mServiceIntent.putExtra(StockTaskService.CALLS.TAG.toString(), StockTaskService.CALLS.ADD.toString());
                                    mServiceIntent.putExtra(Quote.SYMBOL, input.toString());
                                    getActivity().startService(mServiceIntent);
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                                return;
                            }


                        }
                    }).show();
        } else {
            networkToast();
        }

    }


    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVars(savedInstanceState);
    }

    private void initVars(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        if (savedInstanceState == null) {
            mServiceIntent = new Intent(getActivity(), StockIntentService.class);
            mServiceIntent.putExtra(StockTaskService.CALLS.TAG.toString(), StockTaskService.CALLS.INIT.toString());
            mCursorAdapter = new AdapterQuote(new ArrayList<Quote>());
            if (ConnectionUtils.isOnline(getActivity())) {
                getActivity().startService(mServiceIntent);
            } else {
                networkToast();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_home, container, false);
        ButterKnife.bind(this, view);
        intViews();
        return view;
    }


    private void intViews() {
        rVHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {
            mCursorAdapter.setData(QuoteDaoAdapter.getAllQuote());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        recyclerView.addOnItemTouchListener(new RecyclerViewItemClickListener(this,
//                new RecyclerViewItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View v, int position) {
//                        //TODO:
//                        // do something on item click
//                    }
//                }));
        rVHome.setAdapter(mCursorAdapter);
//
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        BusProvider.getInstance().register(this);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        BusProvider.getInstance().unregister(this);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.my_stocks, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                getActivity().onBackPressed();
                return true;
            }
            case R.id.action_settings: {
                return true;
            }
            case R.id.action_change_units: {
                // this is for changing stock changes from percent value to dollar value
                mCursorAdapter.updateShowPercent();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }


    @Subscribe
    public void loadData(EventUpdateData eventUpdateData) {
        if (eventUpdateData.getResult() == GcmNetworkManager.RESULT_SUCCESS) {
            try {
                mCursorAdapter.setData(QuoteDaoAdapter.getAllQuote());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void networkToast() {
        BusProvider.getInstance().postOnUIThread(new EventSnackBarMessage(getString(R.string.network_toast), getView()), getActivity());
    }


}