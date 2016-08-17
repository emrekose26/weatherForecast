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

    public static void setCityName(Context context, String cityName){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("cityname",cityName);
        editor.commit();
    }

    public static String getCityName(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("cityname","");
    }
}
