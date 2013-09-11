package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class NewYork extends CityObserver {
    private int localHourOfTime;

    private NewYork(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static NewYork newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new NewYork(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        this.localHourOfTime = localHourOfTime;
        super.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                super.utcOffset, super.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, super.utcOffset, super.dstStatus);
    }

    @Override
    public String getLocalHourOfTime() {
        return Integer.toString(this.localHourOfTime);
    }
}
