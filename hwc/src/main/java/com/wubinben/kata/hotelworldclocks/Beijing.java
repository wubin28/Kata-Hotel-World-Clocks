package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Beijing extends CityObserver {
    private final int utcOffset;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    public Beijing(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static Beijing newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new Beijing(utcOffset, dstStatus);
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

}
