package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class NewYork extends CityObserver {

    private NewYork(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static NewYork newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new NewYork(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        super.localHourOfTime = localHourOfTime;
        super.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(super.localHourOfTime,
                super.utcOffset, super.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        super.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, super.utcOffset, super.dstStatus);
    }

    @Override
    public String getLocalHourOfTime() {
        return Integer.toString(super.localHourOfTime);
    }
}
