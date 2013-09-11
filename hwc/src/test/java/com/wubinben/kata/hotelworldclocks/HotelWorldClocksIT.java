package com.wubinben.kata.hotelworldclocks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration Test written by JUnit
 * User: Ben
 * Date: 13-9-11
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksIT {
    private HotelWorldClocksFacade hotelWorldClocksFacade;

    @Before
    public void instantiate() {
        this.hotelWorldClocksFacade = HotelWorldClocksFacade.newInstance();
    }

    @Test
    public void testAdjustIncorrectTimeOfBeijing() {
        // Arrange (Given)
        this.hotelWorldClocksFacade.testInitialization();
        this.hotelWorldClocksFacade.addACityWithDstStatus("London", DaylightSavingTime.ACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("New York", DaylightSavingTime.ACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Beijing", DaylightSavingTime.INACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Moscow", DaylightSavingTime.INACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Sydney", DaylightSavingTime.INACTIVE);

        // Act (When)
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(9, "Beijing");

        // Assert (Then)
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(9),
                this.hotelWorldClocksFacade.getResultHour("Beijing"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(2),
                this.hotelWorldClocksFacade.getResultHour("London"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(5),
                this.hotelWorldClocksFacade.getResultHour("Moscow"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(11),
                this.hotelWorldClocksFacade.getResultHour("Sydney"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(21),
                this.hotelWorldClocksFacade.getResultHour("New York"));
    }

    @Test
    public void testEndDaylightSavingPeriodOfLondon() {
        // Arrange (Given)
        this.hotelWorldClocksFacade.testInitialization();
        this.hotelWorldClocksFacade.addACityWithDstStatus("London", DaylightSavingTime.INACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("New York", DaylightSavingTime.ACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Beijing", DaylightSavingTime.INACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Moscow", DaylightSavingTime.INACTIVE);
        this.hotelWorldClocksFacade.addACityWithDstStatus("Sydney", DaylightSavingTime.INACTIVE);

        // Act (When)
        this.hotelWorldClocksFacade.adjustIncorrectTimeOfCity(0, "London");

        // Assert (Then)
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(8),
                this.hotelWorldClocksFacade.getResultHour("Beijing"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(0),
                this.hotelWorldClocksFacade.getResultHour("London"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(4),
                this.hotelWorldClocksFacade.getResultHour("Moscow"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(10),
                this.hotelWorldClocksFacade.getResultHour("Sydney"));
        assertEquals("The result hour is not the same with the expected hour", Integer.toString(20),
                this.hotelWorldClocksFacade.getResultHour("New York"));
    }
}
