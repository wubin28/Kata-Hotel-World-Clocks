package com.wubinben.kata.hotelworldclocks;

/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class London extends CityObserver {
    private static final BenLogger LOGGER = BenLogger.getLogger(BenLogger.LEVEL_OFF);

    private London(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static London newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new London(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        LOGGER.info("in London.setStateOfTimeSubjectWithUtcZeroHourOfTime().");
        LOGGER.info("localHourOfTime: " + localHourOfTime);
        super.localHourOfTime = localHourOfTime;
        super.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(super.localHourOfTime,
                super.utcOffset, super.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        LOGGER.info("in London.updateCityWithUtcZeroHourOfTime().");
        LOGGER.info("utcZeroHourOfTime: " + utcZeroHourOfTime);
        super.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, super.utcOffset, super.dstStatus);
        LOGGER.info("localHourOfTime: " + super.localHourOfTime);
    }

    @Override
    public String getLocalHourOfTime() {
        LOGGER.info("in London.getLocalHourOfTime().");
        LOGGER.info("this.localHourOfTime: " + super.localHourOfTime);
        return Integer.toString(super.localHourOfTime);
    }
}
