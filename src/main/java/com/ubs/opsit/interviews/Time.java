package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * Time holder. Immutable. Validates input parameter on creation.
 * That allows to always be sure that created Time object is valid.
 */
public class Time {

    private final int hours;
    private final int minutes;
    private final int seconds;

    public Time(String time) {
        validate(time);

        String[] parts = time.split(":");
        hours = Integer.parseInt(parts[0]);
        minutes = Integer.parseInt(parts[1]);
        seconds = Integer.parseInt(parts[2]);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void validate(String time) {
        TimeValidator timeValidator = new TimeValidator();
        if (!timeValidator.validate(time)) {
            throw new IllegalArgumentException("Time must not be null");
        }
    }

    private static class TimeValidator {

        private static final Pattern PATTERN_24H_TIME = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
        private static final Pattern PATTERN_MIDNIGHT_TIME = Pattern.compile("24:00:[0-5][0-9]");

        public boolean validate(String time) {
            if (StringUtils.isBlank(time)) {
                return false;
            }
            boolean is24hTime = PATTERN_24H_TIME.matcher(time).matches();
            boolean isMidnightTime = PATTERN_MIDNIGHT_TIME.matcher(time).matches();
            return is24hTime || isMidnightTime;
        }
    }
}


