package com.wubinben.kata.hotelworldclocks;


/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午10:56
 * To change this template use File | Settings | File Templates.
 */
public class Beijing extends CityObserver {
    private static final BenLogger LOGGER = BenLogger.getLogger();
    private final int utcOffset;
    private final TimeSubject timeSubject;
    private DaylightSavingTime dstStatus;
    private int localHourOfTime;

    private Beijing(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
        this.timeSubject = timeSubject;
    }

    public static Beijing newInstance(int utcOffset, DaylightSavingTime dstStatus, TimeSubject timeSubject) {
        return new Beijing(utcOffset, dstStatus, timeSubject);
    }

    @Override
    public void setStateOfTimeSubjectWithUtcZeroHourOfTime(int localHourOfTime) {
        System.out.println("---in Beijing.setStateOfTimeSubjectWithUtcZeroHourOfTime().");
        System.out.println("---localHourOfTime: " + localHourOfTime);
        this.localHourOfTime = localHourOfTime;
        this.timeSubject.setUtcZeroHourOfTime(convertLocalTimeToUtcZeroTime(this.localHourOfTime,
                this.utcOffset, this.dstStatus));
    }

    @Override
    public void updateCityWithUtcZeroHourOfTime(int utcZeroHourOfTime) {
        System.out.println("---in Beijing.updateCityWithUtcZeroHourOfTime()");
        System.out.println("---utcZeroHourOfTime: " + utcZeroHourOfTime);
        this.localHourOfTime = convertUtcZeroTimeToLocalTime(utcZeroHourOfTime, utcOffset, dstStatus);
    }

    @Override
    public String printCityName() {
        return "Beijing";
    }

    @Override
    public String getLocalHourOfTime() {
        LOGGER.info("in Beijing.getLocalHourOfTime().");
        System.out.println("---this.localHourOfTime: " + this.localHourOfTime);
        return Integer.toString(this.localHourOfTime);
    }

}
