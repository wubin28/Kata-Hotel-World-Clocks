package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:15
 * To change this template use File | Settings | File Templates.
 */
public class Sydney extends CityObserver {

    private Sydney(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static Sydney newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Sydney(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                super.utcOffset, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, super.utcOffset, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
