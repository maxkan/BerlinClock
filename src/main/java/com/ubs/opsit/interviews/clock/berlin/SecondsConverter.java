package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;

public class SecondsConverter {

    public String convert(Time time) {
        if (time == null) {
            throw new IllegalArgumentException("Time must not be null");
        }
        return isOdd(time.getSeconds()) ? "O" : "Y";
    }

    private boolean isOdd(int seconds) {
        return seconds % 2 == 1;
    }
}
