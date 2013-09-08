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

    public Beijing(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public static Beijing newInstance(int utcOffset) {
        return new Beijing(utcOffset);
    }
}
