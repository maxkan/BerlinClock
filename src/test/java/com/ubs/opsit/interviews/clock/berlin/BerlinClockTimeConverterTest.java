package com.ubs.opsit.interviews.clock.berlin;

import org.junit.Test;

import static com.ubs.opsit.interviews.clock.berlin.TestHelper.rows;
import static org.junit.Assert.assertEquals;

/**
 * Each unit (seconds, hours and minutes) have test coverage in the corresponding converter tests
 * Here is some converter integration tests and exceptional cases
 */
public class BerlinClockTimeConverterTest {

    @Test
    public void testAllLightsOff() throws Exception {
        String convertedTime = new BerlinClockTimeConverter().convertTime("00:00:01");

        assertEquals(rows("O", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO"), convertedTime);
    }

    @Test
    public void testMaxLightsOn() throws Exception {
        String convertedTime = new BerlinClockTimeConverter().convertTime("23:59:00");

        assertEquals(rows("Y", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY"), convertedTime);
    }

    @Test
    public void testOneLampOfEachUnitOn() throws Exception {
        String convertedTime = new BerlinClockTimeConverter().convertTime("01:01:00");

        assertEquals(rows("Y", "OOOO", "ROOO", "OOOOOOOOOOO", "YOOO"), convertedTime);
    }

    @Test
    public void testOneLampOfEachRowOn() throws Exception {
        String convertedTime = new BerlinClockTimeConverter().convertTime("06:06:00");

        assertEquals(rows("Y", "ROOO", "ROOO", "YOOOOOOOOOO", "YOOO"), convertedTime);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTimeParameter() throws Exception {
        new BerlinClockTimeConverter().convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTimeParameter() throws Exception {
        new BerlinClockTimeConverter().convertTime("");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeParameter() throws Exception {
        new BerlinClockTimeConverter().convertTime("99:99:99");
    }
}