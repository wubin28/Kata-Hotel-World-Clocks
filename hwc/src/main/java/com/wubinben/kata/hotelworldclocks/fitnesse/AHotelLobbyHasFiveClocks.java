package com.wubinben.kata.hotelworldclocks.fitnesse;

import com.wubinben.kata.hotelworldclocks.DaylightSavingTime;
import com.wubinben.kata.hotelworldclocks.HotelWorldClocksFacade;

/**
 * FitNesse Fixture Code
 * User: Ben
 * Date: 13-9-11
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
public class AHotelLobbyHasFiveClocks {

    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public AHotelLobbyHasFiveClocks() {
        this.hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
        this.hotelWorldClocksFacade.testInitialization();
    }

    public void SetCityToBeInTheDSTPeriod(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);

    }

    public void SetCityToBeNotUsingTheDST(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    public void AdjustTheIncorrectTimeOfTheClockOfCityToBeTheCorrectHour(String cityName, int hour) {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }

    public String theTimeOfTheClockOfCityShouldBe(String cityName) {
        return this.hotelWorldClocksFacade.getResultHour(cityName);
    }

    public void EndTheDSTPeriodOfCity(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    public void ContinueTheDSTPeriodOfCity(String cityName) {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    public void AdjustTheTimeOfTheClockOfCityDueToTheEndOfDSTToBe(String cityName, int hour) {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }
}
