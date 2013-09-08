package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:10
 * To change this template use File | Settings | File Templates.
 */
public class Moscow extends CityObserver {
    private final int utcOffset;

    public Moscow(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public static Moscow newInstance(int utcOffset) {
        return new Moscow(utcOffset);
    }
}
