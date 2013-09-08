package com.wubinben.kata.hotelworldclocks;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-7
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class RobotKeywordLibrary {
    /**
     *  Means that that this instance of the class well be used
     *  for whole lifecycle of test execution.
     */
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public RobotKeywordLibrary() {
        this.hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
    }

    public void setCityDstActive(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    public void addToCityList(String cityName) {
    }

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hourOfTime, cityName);
    }

    public String getResultHourOfTime(String cityName) {
        return this.hotelWorldClocksFacade.getResultHourOfTime(cityName);
    }

    public void setCityDstInactive(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    public void adjustTimeOfCityWhenDstEnds(int hourOfTime, String cityName) {
        this.hotelWorldClocksFacade.adjustTimeOfCityWhenDstChanged(hourOfTime, cityName, DaylightSavingTime.INACTIVE);
    }
}
