package com.wubinben.kata.hotelworldclocks;

/**
 * Abstract Observer
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:59
 * To change this template use File | Settings | File Templates.
 */
public abstract class CityObserver {
    public static final int INVALID_HOUR = 100;
    protected TimeSubject timeSubject;
    protected DaylightSavingTime dstStatus;
    protected int localHour;

    public CityObserver(TimeSubject timeSubject, DaylightSavingTime dstStatus) {
        this.timeSubject = timeSubject;
        this.dstStatus = dstStatus;
    }

    public abstract void setTimeToTimeSubject(int localHour);

    public abstract void updateTimeOfCity(int hourUtcZero);

    protected int convertLocalTimeToUtcZeroTime(int hour, int utcOffset, DaylightSavingTime dstStatus) {
        switch (dstStatus) {
            case INACTIVE:
                return hour - utcOffset;
            case ACTIVE:
                return hour - utcOffset - 1;
        }
        return CityObserver.INVALID_HOUR;
    }

    protected int convertUtcZeroTimeToLocalTime(int hourUtcZero, int utcOffset, DaylightSavingTime dstStatus) {
        switch (dstStatus) {
            case INACTIVE:
                return withinTwentyFourHours(hourUtcZero + utcOffset);
            case ACTIVE:
                return withinTwentyFourHours(hourUtcZero + utcOffset + 1);
        }
        return CityObserver.INVALID_HOUR;
    }

    private int withinTwentyFourHours(int hour) {
        if (hour < 0) {
            return hour + 24;
        }
        if (hour > 24) {
            return hour - 24;
        }
        return hour;
    }

    public abstract String getLocalHour();
}
