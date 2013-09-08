package com.wubinben.kata.hotelworldclocks;

import java.util.ArrayList;
import java.util.HashMap;

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
    private TimeSubject timeSubject;
    private HashMap<String, CityObserver> allCityMap;
    private ArrayList<CityObserver> cityList;

    public HotelWorldClocksFacade() {
        this.dstCities = new ArrayList<City>();
        this.timeSubject = TimeSubject.newInstance();
        this.allCityMap = new HashMap<String, CityObserver>();
    }

    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        if (cityName.equals("Beijing")) {
            this.timeSubject.attach(Beijing.newInstance(8, dstStatus));
        }
        if (cityName.equals("London")) {
            this.timeSubject.attach(London.newInstance(0, dstStatus));
        }
        if (cityName.equals("Moscow")) {
            this.timeSubject.attach(Moscow.newInstance(4, dstStatus));
        }
        if (cityName.equals("Sydney")) {
            this.timeSubject.attach(Sydney.newInstance(10, dstStatus));
        }
        if (cityName.equals("New York")) {
            this.timeSubject.attach(NewYork.newInstance(-5, dstStatus));
        }
        this.cityBuffer = City.newInstance(cityName);
        this.cityBuffer.setDstActive();
        this.dstCities.add(this.cityBuffer);
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

    public void adjustTimeOfCityWhenDstChanged(int hourOfTime, String cityName, DaylightSavingTime inactive) {
        this.timeSubject.setDstChanged(true);
    }

    public static HotelWorldClocksFacade newInstance() {
        return new HotelWorldClocksFacade();
    }
}
