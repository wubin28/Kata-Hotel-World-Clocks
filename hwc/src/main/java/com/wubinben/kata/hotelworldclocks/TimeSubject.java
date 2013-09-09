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
    private boolean isDstChanged;
    private HashMap<String, CityObserver> cityMap;
    private int utcZeroHourOfTime;

    public TimeSubject() {
        this.cityMap = new HashMap<String, CityObserver>();
    }

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public static TimeSubject newInstance() {
        return new TimeSubject();
    }

    public void setDstChanged(boolean isDstChanged) {
        this.isDstChanged = isDstChanged;
    }

    public boolean isDstChanged() {
        return this.isDstChanged;
    }

    public void attach(String cityName, CityObserver cityObserver) {
        this.cityMap.put(cityName, cityObserver);
    }

    public CityObserver getCity(String cityName) {
        if (this.cityMap.keySet().contains(cityName)) {
            return this.cityMap.get(cityName);
        }
        throw new IllegalStateException("---No city name in the city map.");
    }

    private void notifyAllCities() {
        Iterator<CityObserver> iterator = this.cityMap.values().iterator();
        while (iterator.hasNext()) {
            CityObserver cityObserver = iterator.next();
            cityObserver.updateCityWithUtcZeroHourOfTime(this.utcZeroHourOfTime);
        }
    }

    public void setUtcZeroHourOfTime(int utcZeroHourOfTime) {
        this.utcZeroHourOfTime = utcZeroHourOfTime;
        notifyAllCities();
    }

}
