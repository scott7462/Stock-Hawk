package com.sam_chordas.android.stockhawk.app.busevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.squareup.otto.Bus;

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
public class UIBus extends Bus {

    private static final String TAG = UIBus.class.getSimpleName();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public void postOnUIThread(final Object event, Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    post(event);
                }
            });
        } else {
            Log.e(TAG, "Attempted to post event on UI thread with null activity!");
        }
    }

    public void postOnNonUIThread(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            post(event);
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    post(event);
                }
            });
        }
    }

    public void postOnUIThreadDelayed(final Object event, int delay) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                post(event);
            }
        }, delay);
    }

}
