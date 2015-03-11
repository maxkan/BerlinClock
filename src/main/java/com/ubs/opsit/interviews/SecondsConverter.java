package com.ubs.opsit.interviews;

/**
 * Created by Max on 3/10/2015.
 */
public class SecondsConverter {
    public String convert(int seconds) {
        return isOdd(seconds) ? "O" : "Y";
    }

    private boolean isOdd(int seconds) {
        return seconds % 2 == 1;
    }
}
