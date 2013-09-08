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

    public NewYork(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public static NewYork newInstance(int utcOffset) {
        return new NewYork(utcOffset);
    }
}
