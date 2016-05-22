package com.sam_chordas.android.stockhawk.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sam_chordas.android.stockhawk.app.App;

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
public class SettingsUtils {

    private static final String PREFS = SettingsUtils.class.getPackage().getName();
    private static final String PREFS_WAITING_CODE_TOKEN = "WAITING_CODE_CODE";
    private static final String PREFS_REMOVE_ALL = "REMOVE_ALL";


    public static void setPreferenceShowPercent(boolean token) {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PREFS_WAITING_CODE_TOKEN, token);
        editor.apply();
    }

    public static boolean getPreferenceShowPercent() {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return settings.contains(PREFS_WAITING_CODE_TOKEN) && settings.getBoolean(PREFS_WAITING_CODE_TOKEN, false);
    }

    public static void setPreferenceRemoveAll(boolean remove) {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PREFS_REMOVE_ALL, remove);
        editor.apply();
    }

    public static boolean getPreferenceRemoveAll() {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return settings.contains(PREFS_REMOVE_ALL) && settings.getBoolean(PREFS_REMOVE_ALL, false);
    }


}
