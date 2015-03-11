package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;

import static java.lang.System.lineSeparator;

public class MinutesConverter {

    private static final int FOUR_BULBS = 4;
    private static final int ELEVEN_BULBS = 11;
    private static final int ONE_MIN_PER_BULB = 1;
    private static final int FIVE_MIN_PER_BULB = 5;
    private static final int EACH_THIRD_IS_SIGNIFICANT = 3;

    private final UnitsToBulbRowConverter topRowUnitConverter;
    private final UnitsToBulbRowConverter bottomRowUnitConverter;

    public MinutesConverter() {
        topRowUnitConverter = new UnitsToBulbRowConverter(ELEVEN_BULBS, FIVE_MIN_PER_BULB, EACH_THIRD_IS_SIGNIFICANT);
        bottomRowUnitConverter = new UnitsToBulbRowConverter(FOUR_BULBS, ONE_MIN_PER_BULB);
    }

    public String convert(Time time) {
        if (time == null) {
            throw new IllegalArgumentException("Time must not be null");
        }

        int minutes = time.getMinutes();
        int minutesForTheBottomRow = minutes % FIVE_MIN_PER_BULB;
        int minutesForTheTopRow = minutes - minutesForTheBottomRow;

        return topRowUnitConverter.convert(minutesForTheTopRow) + lineSeparator()
                + bottomRowUnitConverter.convert(minutesForTheBottomRow);
    }
}
