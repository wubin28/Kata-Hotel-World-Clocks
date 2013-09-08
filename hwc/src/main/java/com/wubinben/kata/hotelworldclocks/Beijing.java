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

    public Beijing(int utcOffset, DaylightSavingTime dstStatus) {
        this.utcOffset = utcOffset;
        this.dstStatus = dstStatus;
    }

    public static Beijing newInstance(int utcOffset, DaylightSavingTime dstStatus) {
        return new Beijing(utcOffset, dstStatus);
    }

}
