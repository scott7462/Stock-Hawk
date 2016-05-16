package com.sam_chordas.android.stockhawk.app.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.sam_chordas.android.stockhawk.R;
import com.sam_chordas.android.stockhawk.app.busevents.events.EventSnackbarMessage;

import java.util.ArrayList;


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
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    protected ArrayList<String> titleStack = new ArrayList<String>();
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Get the toolbar in the baseActivity instance.
     */
    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * Set the toolbar to the baseActivity instance.
     */
    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    /**
     * Method to navigate using  FragmentTransaction and FragmentManager.
     */
    public static void navigateTo(FragmentManager manager, Fragment newFragment, int containerId, boolean options) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(containerId, newFragment, newFragment.getClass().getSimpleName());
        if (options) {
            ft.addToBackStack(newFragment.getClass().getSimpleName());
        }
        ft.commit();
    }

    /**
     * clean Fragment Stack in the FragmentManager.
     */
    public static void cleanFragmentStack(FragmentManager fm) {
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    /**
     * Update the toolbar title.
     */
    public void updateActionBarTitle() {
        if (getToolbar() != null) {
            getToolbar().setTitle(titleStack.get(titleStack.size() - 1));
        }
    }

    /**
     * Navigate in the R.id.container with the SupportFragmentManager.
     */
    public void navigateMainContent(Fragment frg, String title) {
        cleanFragmentStack(getSupportFragmentManager());
        navigateTo(getSupportFragmentManager(), frg, R.id.container, false);
        titleStack.clear();
        titleStack.add(title);
        updateActionBarTitle();
    }

    /**
     * Navigate in the any FrameLayout container with the SupportFragmentManager.
     */
    public void navigateDetailContent(Fragment frg, String title, int container) {
        cleanFragmentStack(getSupportFragmentManager());
        navigateTo(getSupportFragmentManager(), frg, container, false);
        titleStack.clear();
        titleStack.add(title);
        updateActionBarTitle();
    }

    public void handleSnackBarMessageEvent(final EventSnackbarMessage event) {
        this.clearKeyboardFromScreen();
        final Snackbar snackBar = Snackbar.make(event.getView(), event.getText(), Snackbar.LENGTH_LONG);
        if (event.getActionLabelColor() != 0) {
            snackBar.setActionTextColor(-1);
        }

        TextView tv = (TextView) snackBar.getView().findViewById(event.getTextId());
        if (event.getTextColor() != 0) {
            if (tv == null) {
                Log.i(TAG, this.getString(R.string.base_activity_snack_bar_missing_id_error));
            } else {
                tv.setTextColor(event.getTextColor());
            }
        }

        snackBar.setCallback(new Snackbar.Callback() {
            public void onDismissed(Snackbar snackbar, int eventCode) {
                super.onDismissed(snackbar, eventCode);
                if (event.getOnDetachedToWindowRunnable() != null && event.getOnDetachedToWindowRunnable()[0] != null) {
                    event.getOnDetachedToWindowRunnable()[0].run();
                }

            }

            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                if (event.getOnAttachedToWindowRunnable() != null && event.getOnAttachedToWindowRunnable()[0] != null) {
                    event.getOnAttachedToWindowRunnable()[0].run();
                }

            }
        });
        if (event.isCentered()) {
            tv.setGravity(1);
        }

        if (event.isActionDismiss()) {
            snackBar.setAction(event.getActionLabel(), new android.view.View.OnClickListener() {
                public void onClick(View v) {
                    snackBar.dismiss();
                }
            }).show();
        } else {
            snackBar.setAction(event.getActionLabel(), event.getEventListener()).show();
        }

    }

    public void clearKeyboardFromScreen() {
        if (this.getWindow().getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(this.getWindow().getCurrentFocus().getWindowToken(), 0);
        }
    }

}
