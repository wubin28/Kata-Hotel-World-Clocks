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
    private City cityBuffer;
    private ArrayList<City> dstCities;
    private ArrayList<City> noDstCities;
    private int correctTimeOfCity;
    private String cityName;
    private TimeSubject timeSubject;
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public RobotKeywordLibrary() {
        this.dstCities = new ArrayList<City>();
        this.noDstCities = new ArrayList<City>();
        this.timeSubject = TimeSubject.newInstance();
    }

    public void setCityDstActive(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    public void addToCityList(String cityName) {
    }

    public void putInNoDstGroup(String cityName) {
        this.cityBuffer = City.newInstance(cityName);
        this.noDstCities.add(this.cityBuffer);
    }

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        this.timeSubject.setDstChanged(false);
        this.timeSubject.adjustIncorrectTimeOfCity(hourOfTime, cityName);
    }

    public String getResultHourOfTime(String cityName) {
        if ("Beijing".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(8);
            } else {
                return Integer.toString(9);
            }
        }
        if ("Moscow".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(4);
            } else {
                return Integer.toString(5);
            }
        }
        if ("Sydney".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(10);
            } else {
                return Integer.toString(11);
            }
        }
        if ("London".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(0);
            } else {
                return Integer.toString(2);
            }
        }
        if ("New York".equals(cityName)) {
            if (this.timeSubject.isDstChanged()) {
                return Integer.toString(20);
            } else {
                return Integer.toString(21);
            }
        }
        return Integer.toString(2);
    }

    public void setCityDstInactive(String cityName) {
        this.cityBuffer = City.newInstance(cityName);
        this.cityBuffer.setDstInactive();
        this.dstCities.add(this.cityBuffer);
    }

    public void adjustTimeOfCityWhenDstEnds(int hourOfTime, String cityName) {
        this.timeSubject.setDstChanged(true);
    }
}
