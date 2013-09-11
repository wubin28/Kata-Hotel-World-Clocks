package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class NewYork extends CityObserver {

    private static final int utcOffset = -5;

    private NewYork(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static NewYork newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new NewYork(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                this.utcOffset, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, this.utcOffset, super.dstStatus);
    }

    @Override
    public String getLocalHour() {
        return Integer.toString(super.localHour);
    }
}
