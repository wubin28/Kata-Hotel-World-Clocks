package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class London extends CityObserver {
    private final int utcOffset;
    private DaylightSavingTime dstStatus;

    public London(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static London newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new London(utcOffset, dstStatus);
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
