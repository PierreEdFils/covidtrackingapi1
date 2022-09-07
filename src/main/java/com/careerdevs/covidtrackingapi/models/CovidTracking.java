package com.careerdevs.covidtrackingapi.models;

public class CovidTracking {



    private boolean success;
    public CovidTracking(String countryName, boolean success) {
        this.data  = countryName;
        this.success = success;
    }



    public boolean isSuccess() {
        return success;
    }
    private String data;

    public String getData() {
        return data;
    }
    public CovidTracking() {
    }


}
