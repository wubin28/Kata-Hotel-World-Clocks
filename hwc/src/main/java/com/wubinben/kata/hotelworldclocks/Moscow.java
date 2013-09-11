package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
public class Moscow extends CityObserver {
    private int localHourOfTime;

    private Moscow(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static Moscow newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Moscow(utcOffset, dstStatus, timeSubject);
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
