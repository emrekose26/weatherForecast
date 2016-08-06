package com.emrekose.weatherapp.utils;

/**
 * Created by emrekose on 6.08.2016.
 */
public class WeatherCalc {

    public static String kelvinToCelcius(Double value){
        int celcius = (int) (value - 273.15);
        return String.valueOf(celcius) + "°";
    }
}
