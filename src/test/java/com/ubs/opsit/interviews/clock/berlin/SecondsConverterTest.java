package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecondsConverterTest {

    public SecondsConverter secondsConverter;

    @Before
    public void setup() {
        secondsConverter = new SecondsConverter();
    }

    @Test
    public void testConvertZeroSeconds() throws Exception {
        String convertedSeconds = secondsConverter.convert(new Time("00:00:00"));

        assertEquals("Y", convertedSeconds);
    }

    @Test
    public void testConvertOneSecond() throws Exception {
        String convertedSeconds = secondsConverter.convert(new Time("00:00:01"));

        assertEquals("O", convertedSeconds);
    }

    @Test
    public void testConvertTwoSeconds() throws Exception {
        String convertedSeconds = secondsConverter.convert(new Time("00:00:02"));

        assertEquals("Y", convertedSeconds);
    }


    @Test
    public void testConvertLastSecondOfAMinute() throws Exception {
        String convertedSeconds = secondsConverter.convert(new Time("00:00:59"));

        assertEquals("O", convertedSeconds);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullTime() {
        secondsConverter.convert(null);
    }
}