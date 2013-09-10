package com.wubinben.kata.hotelworldclocks;


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

    public void adjustIncorrectTimeOfCity(int hourOfTime, String cityName) {
        LOGGER.info("in RobotKeywordLibrary.adjustIncorrectTimeOfCity().");
        LOGGER.info("hourOfTime: " + hourOfTime);
        LOGGER.info("cityName: " + cityName);
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hourOfTime, cityName);
    }

    public String getResultHourOfTime(String cityName) {
        LOGGER.info("in RobotKeywordLibrary.getResultHourOfTime().");
        return this.hotelWorldClocksFacade.getResultHourOfTime(cityName);
    }

    public void adjustTimeOfCityWhenDstEnds(int hourOfTime, String cityName) {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hourOfTime, cityName);
    }
}
