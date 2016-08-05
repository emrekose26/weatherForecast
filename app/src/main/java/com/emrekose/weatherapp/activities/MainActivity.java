package com.emrekose.weatherapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.emrekose.weatherapp.R;
import com.emrekose.weatherapp.utils.Font;
import com.emrekose.weatherapp.utils.JSONUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView cityTexView, countryTextView, degreeTextView, weatherDescriptionTexView,
    timeTextView, dateTextView, maxMinTemperatureTexView, humidityTextView, windTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }


    private void initialize(){
        cityTexView = (TextView)findViewById(R.id.cityTextView);
        countryTextView = (TextView)findViewById(R.id.countryTextView);
        degreeTextView = (TextView)findViewById(R.id.degreeTextView);
        weatherDescriptionTexView = (TextView)findViewById(R.id.weatherDescTextView);
        timeTextView = (TextView)findViewById(R.id.timeTextView);
        dateTextView = (TextView)findViewById(R.id.dateTextView);
        maxMinTemperatureTexView = (TextView)findViewById(R.id.maxMinTemperatureTexView);
        humidityTextView = (TextView)findViewById(R.id.humidityTextView);
        windTextView = (TextView)findViewById(R.id.windTextView);

        // all of textView is font changing
        Font.change(MainActivity.this,cityTexView, Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(MainActivity.this,countryTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,weatherDescriptionTexView,Font.OPEN_SANS_COND_BOLD_PATH);
        Font.change(MainActivity.this,degreeTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,timeTextView,Font.OPEN_SANS_COND_LIGHT_ITALIC_PATH);
        Font.change(MainActivity.this,dateTextView,Font.OPEN_SANS_COND_LIGHT_ITALIC_PATH);
        Font.change(MainActivity.this,maxMinTemperatureTexView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,humidityTextView,Font.OPEN_SANS_COND_LIGHT_PATH);
        Font.change(MainActivity.this,windTextView,Font.OPEN_SANS_COND_LIGHT_PATH);

    }
}
