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
    private static final int UTC_OFFSET = 0;

    private London(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        super(timeSubject, dstStatus);
    }

    public static London newInstance(DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new London(dstStatus, timeSubject);
    }

    @Override
    public void setTimeToTimeSubject(int localHour) {
        LOGGER.info("in London.setTimeToTimeSubject().");
        LOGGER.info("localHour: " + localHour);
        super.localHour = localHour;
        super.timeSubject.setHourUtcZero(convertLocalTimeToUtcZeroTime(super.localHour,
                London.UTC_OFFSET, super.dstStatus));
    }

    @Override
    public void updateTimeOfCity(int hourUtcZero) {
        LOGGER.info("in London.updateTimeOfCity().");
        LOGGER.info("utcZeroHour: " + hourUtcZero);
        super.localHour = convertUtcZeroTimeToLocalTime(hourUtcZero, London.UTC_OFFSET, super.dstStatus);
        LOGGER.info("localHour: " + super.localHour);
    }

    @Override
    public String getLocalHour() {
        LOGGER.info("in London.getLocalHour().");
        LOGGER.info("this.localHour: " + super.localHour);
        return Integer.toString(super.localHour);
    }
}
