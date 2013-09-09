package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
public class Moscow extends CityObserver {
    private final int utcOffset;
    private DaylightSavingTime dstStatus;

    public Moscow(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static Moscow newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new Moscow(utcOffset, dstStatus);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int hourOfTime) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
