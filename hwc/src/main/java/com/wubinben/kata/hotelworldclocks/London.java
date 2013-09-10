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
    private TimeSubject timeSubject;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    private London(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
        this.timeSubject = timeSubject;
    }

    public static London newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new London(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        System.out.println("---in London.setStateOfTimeSubjectWithUtcZeroHourOfTime().");
        System.out.println("---localHourOfTime: " + localHourOfTime);
        this.localHourOfTime = localHourOfTime;
        this.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                this.utcOffset, this.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        System.out.println("---in London.updateCityWithUtcZeroHourOfTime().");
        System.out.println("---utcZeroHourOfTime: " + utcZeroHourOfTime);
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, utcOffset, dstStatus);
        System.out.println("---localHourOfTime: " + localHourOfTime);
    }

    @Override
    public String printCityName() {
        return "London";
    }
    @Override
    public String getLocalHourOfTime() {
        System.out.println("---in London.getLocalHourOfTime().");
        System.out.println("---this.localHourOfTime: " + this.localHourOfTime);
        return Integer.toString(this.localHourOfTime);
    }
}
