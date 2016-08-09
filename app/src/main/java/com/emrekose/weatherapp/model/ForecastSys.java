package com.emrekose.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emrekose on 9.08.2016.
 */
public class ForecastSys {

    @SerializedName("pod")
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
