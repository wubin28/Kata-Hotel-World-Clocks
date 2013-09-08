package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 上午8:50
 * To change this template use File | Settings | File Templates.
 */
public class City {
    private final String cityName;
    private boolean isDstActive;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public static City newInstance(String cityName) {
        return new City(cityName);
    }

    public void setDstActive() {
        this.isDstActive = true;
    }

    public void setDstInactive() {
        this.isDstActive = false;
    }
}
