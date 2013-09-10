package com.wubinben.kata.hotelworldclocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksFacade {
    private TimeSubject timeSubject;

    public HotelWorldClocksFacade() {
    }

    public void testInitialization() {
        this.timeSubject = TimeSubject.newInstance();
    }
    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        System.out.println("---in HotelWorldClocksFacade.addACityWithDstStatus()");
        if (cityName.equals("Beijing")) {
            this.timeSubject.attach("Beijing", Beijing.newInstance(8, dstStatus, this.timeSubject));
            System.out.println("---attached Beijing");
        }
        if (cityName.equals("London")) {
            this.timeSubject.attach("London", London.newInstance(0, dstStatus, this.timeSubject));
            System.out.println("---attached London");
        }
        if (cityName.equals("Moscow")) {
            this.timeSubject.attach("Moscow", Moscow.newInstance(4, dstStatus, this.timeSubject));
            System.out.println("---attached Moscow");
        }
        if (cityName.equals("Sydney")) {
            this.timeSubject.attach("Sydney", Sydney.newInstance(10, dstStatus, this.timeSubject));
            System.out.println("---attached Sydney");
        }
        if (cityName.equals("New York")) {
            this.timeSubject.attach("New York", NewYork.newInstance(-5, dstStatus, this.timeSubject));
            System.out.println("---attached New York");
        }
    }

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        System.out.println("---in HotelWorldClocksFacade.adjustIncorrectTimeOfCity().");
        System.out.println("---hourOfTime: " + hourOfTime);
        System.out.println("---cityName: " + cityName);
        this.timeSubject.getCity(cityName).setStateOfTimeSubjectWithUtcZeroHourOfTime(hourOfTime);
    }

    public String getResultHourOfTime(String cityName) {
        System.out.println("---in HotelWorldClocksFacade.getResultHourOfTime().");
        return this.timeSubject.getCity(cityName).getLocalHourOfTime();
    }

    public static HotelWorldClocksFacade newInstance() {
        return new HotelWorldClocksFacade();
    }

    public void adjustTimeOfCityWhenDstChanged(int hourOfTime, String cityName, DaylightSavingTime dstStatus) {
        this.timeSubject.getCity(cityName).setStateOfTimeSubjectWithUtcZeroHourOfTime(hourOfTime);
    }

}
