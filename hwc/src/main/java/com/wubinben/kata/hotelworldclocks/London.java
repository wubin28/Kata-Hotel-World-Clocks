package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class London extends CityObserver {
    private final int utcOffset;

    public London(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public static London newInstance(int utcOffset) {
        return new London(utcOffset);
    }
}
