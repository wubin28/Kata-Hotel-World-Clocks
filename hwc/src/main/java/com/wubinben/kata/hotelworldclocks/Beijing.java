package com.wubinben.kata.hotelworldclocks;


/**
 * A concrete observer.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Beijing extends CityObserver {
    private static final BenLogger LOGGER = BenLogger.getLogger(BenLogger.LEVEL_OFF);
    private int localHourOfTime;

    private Beijing(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, utcOffset, dstStatus);
    }

    public static Beijing newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Beijing(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        LOGGER.info("in Beijing.setStateOfTimeSubjectWithUtcZeroHourOfTime().");
        LOGGER.info("localHourOfTime: " + localHourOfTime);
        this.localHourOfTime = localHourOfTime;
        super.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                super.utcOffset, super.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        LOGGER.info("in Beijing.updateCityWithUtcZeroHourOfTime()");
        LOGGER.info("utcZeroHourOfTime: " + utcZeroHourOfTime);
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, super.utcOffset, super.dstStatus);
    }

    @Override
    public String getLocalHourOfTime() {
        LOGGER.info("in Beijing.getLocalHourOfTime().");
        LOGGER.info("this.localHourOfTime: " + this.localHourOfTime);
        return Integer.toString(this.localHourOfTime);
    }

}
