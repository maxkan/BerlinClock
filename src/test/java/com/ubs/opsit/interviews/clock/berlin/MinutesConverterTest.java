package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.clock.berlin.TestHelper.rows;
import static org.junit.Assert.assertEquals;

public class MinutesConverterTest {

    private MinutesConverter minutesConverter;

    @Before
    public void setup() {
        minutesConverter = new MinutesConverter();
    }

    @Test
    public void testAllBulbsIsOff() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:00:00"));

        assertEquals(rows("OOOOOOOOOOO", "OOOO"), convertedMinutes);
    }

    @Test
    public void testAllBulbsIsOn() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:59:00"));

        assertEquals(rows("YYRYYRYYRYY", "YYYY"), convertedMinutes);
    }

    @Test
    public void testTopRowIsOn() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:55:00"));

        assertEquals(rows("YYRYYRYYRYY", "OOOO"), convertedMinutes);
    }

    @Test
    public void testBottomRowIsOn() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:04:00"));

        assertEquals(rows("OOOOOOOOOOO", "YYYY"), convertedMinutes);
    }

    @Test
    public void testTopRowIsOnUpToFirstSignificantBulb() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:15:00"));

        assertEquals(rows("YYROOOOOOOO", "OOOO"), convertedMinutes);
    }

    @Test
    public void testTopRowIsOnUpToSecondSignificantBulb() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:30:00"));

        assertEquals(rows("YYRYYROOOOO", "OOOO"), convertedMinutes);
    }

    @Test
    public void testTopRowIsOnUpToThirdSignificantBulb() throws Exception {
        String convertedMinutes = minutesConverter.convert(new Time("00:45:00"));

        assertEquals(rows("YYRYYRYYROO", "OOOO"), convertedMinutes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        minutesConverter.convert(null);
    }
}