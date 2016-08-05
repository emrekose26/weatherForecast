package com.emrekose.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 5.08.2016.
 */
public class Clouds {
    @SerializedName("all")
    private Double all;

    public Double getAll() {
        return all;
    }

    public void setAll(Double all) {
        this.all = all;
    }
}
