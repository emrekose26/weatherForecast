package com.emrekose.weatherapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by emrekose on 8.08.2016.
 */

public class SharedPrefUtils {

    public static void setGPSCondition(Context context ,int condition){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("gps", condition);
        editor.commit();
    }

    public static int getGPSCondition(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt("gps",-1);
    }
}
