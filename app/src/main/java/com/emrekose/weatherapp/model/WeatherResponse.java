package com.emrekose.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by emrekose on 5.08.2016.
 */
public class WeatherResponse {

    @SerializedName("coord")
    private List<Coord> coordList;

    @SerializedName("weather")
    private List<Weather> weatherList;

    @SerializedName("base")
    private String base;

    @SerializedName("main")
    private List<MainModel> mainModelList;

    @SerializedName("wind")
    private List<Wind> windList;

    @SerializedName("rain")
    private List<Rain> rainList;

    @SerializedName("clouds")
    private List<Clouds> cloudsList;

    @SerializedName("dt")
    private int dt;

    @SerializedName("sys")
    private List<Sys> sysList;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("cod")
    private int cod;

    public List<Coord> getCoordList() {
        return coordList;
    }

    public void setCoordList(List<Coord> coordList) {
        this.coordList = coordList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public List<MainModel> getMainModelList() {
        return mainModelList;
    }

    public void setMainModelList(List<MainModel> mainModelList) {
        this.mainModelList = mainModelList;
    }

    public List<Wind> getWindList() {
        return windList;
    }

    public void setWindList(List<Wind> windList) {
        this.windList = windList;
    }

    public List<Rain> getRainList() {
        return rainList;
    }

    public void setRainList(List<Rain> rainList) {
        this.rainList = rainList;
    }

    public List<Clouds> getCloudsList() {
        return cloudsList;
    }

    public void setCloudsList(List<Clouds> cloudsList) {
        this.cloudsList = cloudsList;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public List<Sys> getSysList() {
        return sysList;
    }

    public void setSysList(List<Sys> sysList) {
        this.sysList = sysList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
