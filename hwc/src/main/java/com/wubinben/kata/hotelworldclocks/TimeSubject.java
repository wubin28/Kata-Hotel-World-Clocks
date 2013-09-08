package com.wubinben.kata.hotelworldclocks;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public class TimeSubject {
    private boolean isDstChanged;

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public static TimeSubject newInstance() {
        return new TimeSubject();
    }

    public void setDstChanged(boolean isDstChanged) {
        this.isDstChanged = isDstChanged;
    }

    public boolean isDstChanged() {
        return this.isDstChanged;
    }
}
