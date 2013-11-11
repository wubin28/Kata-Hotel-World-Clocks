package com.wubinben.kata.hotelworldclocks;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;


/**
 * Step definitions file for cucumber-jvm
 * User: Ben
 * Date: 13-9-10
 * Time: 下午11:18
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksStepdefs {
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    public HotelWorldClocksStepdefs() {
        this.hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
    }

    @Given("^a hotel lobby has five clocks|一个酒店大堂有五个城市的时钟$")
    public void a_hotel_lobby_has_five_clocks() throws Throwable {
        this.hotelWorldClocksFacade.testInitialization();
    }

    @Given("^\"([^\"]*)\"(?: is in the DST period|正实行夏时制)$")
    public void is_in_the_DST_period(String cityName) throws Throwable {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    @Given("^\"([^\"]*)\"(?: does not use the DST|未实行夏时制)$")
    public void does_not_use_the_DST(String cityName) throws Throwable {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    @When("^(?:I adjust the incorrect time of the clock of |我将)\"([^\"]*)\"(?: to be |的时钟的时间调整到)(\\d+)$")
    public void I_adjust_the_incorrect_time_of_the_clock_of_to_be(String cityName, int hour) throws Throwable {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }

    @Then("^(?:the time of the clock of |城市)\"([^\"]*)\"(?: should be |的时钟的时间应该是)(\\d+)$")
    public void the_time_of_the_clock_of_should_be(String cityName, int expectedHour) throws Throwable {
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(expectedHour), this.hotelWorldClocksFacade.getResultHour(cityName));
    }

    @Given("^the DST period of \"([^\"]*)\" ends$")
    public void the_DST_period_of_ends(String cityName) throws Throwable {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.INACTIVE);
    }

    @Given("^the DST period of \"([^\"]*)\" does not end$")
    public void the_DST_period_of_does_not_end(String cityName) throws Throwable {
        this.hotelWorldClocksFacade.addACityWithDstStatus(cityName, DaylightSavingTime.ACTIVE);
    }

    @When("^I adjust the time of the clock of \"([^\"]*)\" to be (\\d+) due to the end of DST$")
    public void I_adjust_the_time_of_the_clock_of_to_be_due_to_the_end_of_DST(String cityName, int hour) throws Throwable {
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(hour, cityName);
    }
}
