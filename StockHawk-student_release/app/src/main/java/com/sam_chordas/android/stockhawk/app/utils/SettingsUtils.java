package com.sam_chordas.android.stockhawk.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sam_chordas.android.stockhawk.app.App;

/**
 * Created by Pedro Scott on 3/12/15.
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
        if (settings.contains(PREFS_WAITING_CODE_TOKEN))
            return settings.getBoolean(PREFS_WAITING_CODE_TOKEN, false);
        return false;
    }

    public static void setPreferenceRemoveAll(boolean remove) {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(PREFS_REMOVE_ALL, remove);
        editor.apply();
    }

    public static boolean getPreferenceRemoveAll() {
        SharedPreferences settings = App.getGlobalContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        if (settings.contains(PREFS_REMOVE_ALL))
            return settings.getBoolean(PREFS_REMOVE_ALL, false);
        return false;
    }


}
