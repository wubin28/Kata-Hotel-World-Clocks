package com.wubinben.kata.hotelworldclocks;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksFacade {
    private City cityBuffer;
    private ArrayList<City> dstCities;

    public HotelWorldClocksFacade() {
        this.dstCities = new ArrayList<City>();
    }

    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        this.cityBuffer = City.newInstance(cityName);
        this.cityBuffer.setDstActive();
        this.dstCities.add(this.cityBuffer);
    }
}
