package com.emrekose.weatherapp.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

/**
 * Created by emrekose on 8.08.2016.
 */

public class WeatherLocation implements LocationListener {

    private Double lat;
    private Double lon;

    private Context context;

    public WeatherLocation(Context context) {
        this.context = context;
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        SharedPrefUtils.setGPSCondition(context,1);
    }

    @Override
    public void onProviderDisabled(String provider) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage("GPS şuanda kapalı açmak ister misiniz ? ")
                .setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        context.startActivity(intent);
                        SharedPrefUtils.setGPSCondition(context,1);
                    }
                })
                .setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPrefUtils.setGPSCondition(context,0);
                    }
                }).show();
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
