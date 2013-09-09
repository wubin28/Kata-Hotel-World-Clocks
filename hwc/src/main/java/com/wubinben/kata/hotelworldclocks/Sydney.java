package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:15
 * To change this template use File | Settings | File Templates.
 */
public class Sydney extends CityObserver {
    private final int utcOffset;
    private TimeSubject timeSubject;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    public Sydney(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
        this.timeSubject = TimeSubject.newInstance();
    }

    public static Sydney newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new Sydney(utcOffset, dstStatus);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        this.localHourOfTime = localHourOfTime;
        this.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                this.utcOffset, this.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, utcOffset, dstStatus);
    }

    @Override
    public String printCityName() {
        return "Sydney";
    }
}
