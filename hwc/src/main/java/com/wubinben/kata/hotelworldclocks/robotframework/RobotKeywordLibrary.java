package com.wubinben.kata.hotelworldclocks.robotframework;


import com.wubinben.kata.hotelworldclocks.BenLogger;
import com.wubinben.kata.hotelworldclocks.DaylightSavingTime;
import com.wubinben.kata.hotelworldclocks.HotelWorldClocksFacade;

/**
 * The fixture code.
 * User: Ben
 * Date: 13-9-7
 * Time: 下午11:09
 * To change this template use File | Settings | File Templates.
 */
public class RobotKeywordLibrary {
    private static final BenLogger LOGGER = BenLogger.getLogger(BenLogger.LEVEL_OFF);
    /**
     *  Means that that this instance of the class well be used
     *  for whole lifecycle of test execution.
     */
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public RobotKeywordLibrary() {
        this.hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
    }

    public void testInitialization() {
        this.hotelWorldClocksFacade.testInitialization();
    }

    public void setCityDstActiveAndAddToCityList(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    public void setCityDstInactiveAndAddToCityList(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    public void adjustIncorrectTimeOfCity(int hour, String cityName) {
        LOGGER.info("in RobotKeywordLibrary.adjustIncorrectTimeOfCity().");
        LOGGER.info("hour: " + hour);
        LOGGER.info("cityName: " + cityName);
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }

    public String getResultHour(String cityName) {
        LOGGER.info("in RobotKeywordLibrary.getResultHour().");
        return this.hotelWorldClocksFacade.getResultHour(cityName);
    }

    public void adjustTimeOfCityWhenDstEnds(int hour, String cityName) {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }
}
