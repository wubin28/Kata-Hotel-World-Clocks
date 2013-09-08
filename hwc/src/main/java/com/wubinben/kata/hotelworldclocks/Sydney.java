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

    public Sydney(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public static Sydney newInstance(int utcOffset) {
        return new Sydney(utcOffset);
    }
}
