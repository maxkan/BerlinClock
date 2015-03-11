package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TimeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        new Time(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyInput() {
        new Time("");
    }

    @Test
    public void test24hTime() {
        Time time = new Time("23:58:59");

        assertSame(23, time.getHours());
        assertSame(58, time.getMinutes());
        assertSame(59, time.getSeconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTime() {
        new Time("23:68:59");
    }

    @Test
    public void testMidnightTime() {
        Time time = new Time("24:00:59");

        assertSame(24, time.getHours());
        assertSame(0, time.getMinutes());
        assertSame(59, time.getSeconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMidnightTime() {
        new Time("24:01:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTimeWithNegativeUnits() {
        new Time("-01:-01:-01");
    }

}