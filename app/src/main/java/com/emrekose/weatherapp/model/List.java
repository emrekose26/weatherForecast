package com.emrekose.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 9.08.2016.
 */
public class List {

    @SerializedName("dt")
    private int dt;

    @SerializedName("main")
    private ForecastMain forecastMain;

    @SerializedName("weather")
    private java.util.List<ForecastWeather> forecastWeatherList;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("sys")
    private ForecastSys forecastSys;

    @SerializedName("dt_txt")
    private String dtTxt;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public ForecastMain getForecastMain() {
        return forecastMain;
    }

    public void setForecastMain(ForecastMain forecastMain) {
        this.forecastMain = forecastMain;
    }

    public java.util.List<ForecastWeather> getForecastWeatherList() {
        return forecastWeatherList;
    }

    public void setForecastWeatherList(java.util.List<ForecastWeather> forecastWeatherList) {
        this.forecastWeatherList = forecastWeatherList;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public ForecastSys getForecastSys() {
        return forecastSys;
    }

    public void setForecastSys(ForecastSys forecastSys) {
        this.forecastSys = forecastSys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
