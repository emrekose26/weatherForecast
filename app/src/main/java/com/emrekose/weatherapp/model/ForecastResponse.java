package com.emrekose.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * Created by emrekose on 9.08.2016.
 */
public class ForecastResponse {

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private Double message;

    @SerializedName("city")
    private City city;

    @SerializedName("cnt")
    private Integer cnt;

    @SerializedName("list")
    private java.util.List<List> lists;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getLists() {
        return lists;
    }

    public void setLists(java.util.List<List> lists) {
        this.lists = lists;
    }
}
