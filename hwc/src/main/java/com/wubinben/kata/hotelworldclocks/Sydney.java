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
    private DaylightSavingTime dstStatus;

    public Sydney(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static Sydney newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new Sydney(utcOffset, dstStatus);
    }

}
