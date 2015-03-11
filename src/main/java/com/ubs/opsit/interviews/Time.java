package com.ubs.opsit.interviews;

/**
 * Created by Max on 3/10/2015.
 */
public class Time {

    private final int hours;
    private final int minutes;
    private final int seconds;

    public Time(String time) {
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
}
