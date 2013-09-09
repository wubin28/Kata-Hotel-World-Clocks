package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:59
 * To change this template use File | Settings | File Templates.
 */
public abstract class CityObserver {
    public static final int INVALID_HOUR_OF_TIME = 100;
    public TimeSubject timeSubject;

    public abstract void setStateOfTimeSubjectWithUtcZeroHourOfTime(int hourOfTime);

    public abstract void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime);
}
