package com.wubinben.kata.hotelworldclocks;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public class TimeSubject {
    private HashMap<String, CityObserver> cityMap;
    private int utcZeroHourOfTime;

    public TimeSubject() {
        this.cityMap = new HashMap<String, CityObserver>();
    }

    public static TimeSubject newInstance() {
        return new TimeSubject();
    }

    public void attach(String cityName, CityObserver cityObserver) {
        this.cityMap.put(cityName, cityObserver);
    }

    public CityObserver getCity(String cityName) {
        System.out.println("---in TimeSubject.getCity().");
        if (this.cityMap.keySet().contains(cityName)) {
            System.out.println("---contains: " + cityName);
            return this.cityMap.get(cityName);
        }
        throw new IllegalStateException("---No city name in the city map.");
    }

    private void notifyAllCities() {
        System.out.println("---in TimeSubject.notifyAllCities().");
        System.out.println("---size of cityMap: " + this.cityMap.size());
        Iterator<String> cityNames = this.cityMap.keySet().iterator();
        System.out.println("---cityNames.hasNext(): " + cityNames.hasNext());
        Iterator<CityObserver> cityObservers = this.cityMap.values().iterator();
        System.out.println("---cityObservers.hasNext(): " + cityObservers.hasNext());
        while (cityObservers.hasNext()) {
            System.out.println("---in loop");
            CityObserver cityObserver = cityObservers.next();
            cityObserver.updateCityWithUtcZeroHourOfTime(this.utcZeroHourOfTime);
        }
    }

    public void setUtcZeroHourOfTime(int utcZeroHourOfTime) {
        System.out.println("---in TimeSubject.setUtcZeroHourOfTime().");
        System.out.println("---utcZeroHourOfTime: " + utcZeroHourOfTime);
        this.utcZeroHourOfTime = utcZeroHourOfTime;
        notifyAllCities();
    }

}
