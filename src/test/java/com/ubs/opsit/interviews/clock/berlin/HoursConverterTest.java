package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.clock.berlin.TestHelper.rows;
import static org.junit.Assert.assertEquals;

public class HoursConverterTest {

    private HoursConverter hoursConverter;

    @Before
    public void setup() {
        hoursConverter = new HoursConverter();
    }

    @Test
    public void testAllBulbsOff() throws Exception {
        String convertedHours = hoursConverter.convert(new Time("00:00:00"));

        assertEquals(rows("OOOO", "OOOO"), convertedHours);
    }

    @Test
    public void testAllBulbsOn() throws Exception {
        String convertedHours = hoursConverter.convert(new Time("24:00:00"));

        assertEquals(rows("RRRR", "RRRR"), convertedHours);
    }

    @Test
    public void testTopRowOn() throws Exception {
        String convertedHours = hoursConverter.convert(new Time("20:00:00"));

        assertEquals(rows("RRRR", "OOOO"), convertedHours);
    }

    @Test
    public void testBottomRowOn() throws Exception {
        String convertedHours = hoursConverter.convert(new Time("04:00:00"));

        assertEquals(rows("OOOO", "RRRR"), convertedHours);
    }

    @Test
    public void testHalfOfEachRowOn() throws Exception {
        String convertedHours = hoursConverter.convert(new Time("12:00:00"));

        assertEquals(rows("RROO", "RROO"), convertedHours);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        hoursConverter.convert(null);
    }
}