package com.emrekose.weatherapp.rest;

import com.emrekose.weatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by emrekose on 6.08.2016.
 */

public interface ApiInterface {
    @GET("weather")
    Call<WeatherResponse> getCurrentDatas(@Query("q") String city, @Query("appid") String apiKey);

    @GET("forecast")
    Call<WeatherResponse> getFiveDaysDatas(@Query("q") String city, @Query("appid") String apiKey);
}
