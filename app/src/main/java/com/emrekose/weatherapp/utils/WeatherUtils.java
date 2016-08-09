package com.emrekose.weatherapp.utils;

import android.widget.ImageView;

import com.emrekose.weatherapp.R;

/**
 * Created by emrekose on 6.08.2016.
 */
public class WeatherUtils {

    public static void setWeatherIcon(ImageView imageView, String iconName){

        switch (iconName){
            case "01d" : imageView.setImageResource(R.drawable.dayzeroone);break;
            case "01n" : imageView.setImageResource(R.drawable.nightzeroone);break;
            case "02d" : imageView.setImageResource(R.drawable.dayzerotwo);break;
            case "02n" : imageView.setImageResource(R.drawable.nightzerotwo); break;
            case "03d" : imageView.setImageResource(R.drawable.zerothree); break;
            case "03n" : imageView.setImageResource(R.drawable.zerothree); break;
            case "04n" : imageView.setImageResource(R.drawable.zerofour);break;
            case "04d" : imageView.setImageResource(R.drawable.zerofour);break;
            case "09d" : imageView.setImageResource(R.drawable.zeronine);break;
            case "09n" : imageView.setImageResource(R.drawable.zeronine);break;
            case "10d" : imageView.setImageResource(R.drawable.dayonezero);break;
            case "10n" : imageView.setImageResource(R.drawable.nightonezero);break;
            case "11d" : imageView.setImageResource(R.drawable.oneone);break;
            case "11n" : imageView.setImageResource(R.drawable.oneone);break;
            case "13d" : imageView.setImageResource(R.drawable.onethree);break;
            case "13n" : imageView.setImageResource(R.drawable.onethree);break;
            case "50d" : imageView.setImageResource(R.drawable.dayfivezero);break;
            case "50n" : imageView.setImageResource(R.drawable.nightfivezero);break;
        }
    }

    public static void setFragmentWeatherIcon(ImageView imageView, String iconName){

        switch (iconName){
            case "01d" :
            case "01n" : imageView.setImageResource(R.drawable.fdayzeroone);
                break;

            case "02d" :
            case "02n" : imageView.setImageResource(R.drawable.fdayzerotwo);
                break;

            case "03d" :
            case "03n" : imageView.setImageResource(R.drawable.fdayzerothree);
                break;

            case "04d" :
            case "04n" : imageView.setImageResource(R.drawable.fdayzerofour);
                break;

            case "09d" :
            case "09n" : imageView.setImageResource(R.drawable.fdayzeronine);
                break;

            case "10d" :
            case "10n" : imageView.setImageResource(R.drawable.fdayonezero);
                break;

            case "11d" :
            case "11n" : imageView.setImageResource(R.drawable.fdayoneone);
                break;

            case "13d" :
            case "13n" : imageView.setImageResource(R.drawable.fdayonethree);
                break;

            case "50d" :
            case "50n" : imageView.setImageResource(R.drawable.fdayfivezero);
                break;
        }

    }

    
}
