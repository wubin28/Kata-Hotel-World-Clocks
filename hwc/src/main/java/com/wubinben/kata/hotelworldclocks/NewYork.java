package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class NewYork extends CityObserver {
    private final int utcOffset;
    private DaylightSavingTime dstStatus;

    public NewYork(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static NewYork newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new NewYork(utcOffset, dstStatus);
    }

}
