package com.ubs.opsit.interviews;

/**
 * Created by Max on 3/10/2015.
 */
public class MinutesConverter {
    private static final int FOUR_BULBS = 4;
    private static final int ELEVEN_BULBS = 11;
    private static final int ONE_MIN_PER_BULB = 1;
    private static final int FIVE_MIN_PER_BULB = 5;
    private static final int EACH_THIRD_IS_SIGNIFICANT = 3;

    private final UnitsToBulbsConverter topRowUnitConverter;
    private final UnitsToBulbsConverter bottomRowUnitConverter;

    public MinutesConverter() {
        topRowUnitConverter = new UnitsToBulbsConverter(ELEVEN_BULBS, FIVE_MIN_PER_BULB, EACH_THIRD_IS_SIGNIFICANT);
        bottomRowUnitConverter = new UnitsToBulbsConverter(FOUR_BULBS, ONE_MIN_PER_BULB);
    }

    public String convert(int minuteOfHour) {
        int minutesForTheBottomRow = minuteOfHour % FIVE_MIN_PER_BULB;
        int minutesForTheTopRow = minuteOfHour - minutesForTheBottomRow;

        return topRowUnitConverter.convert(minutesForTheTopRow) + System.lineSeparator()
                + bottomRowUnitConverter.convert(minutesForTheBottomRow);
    }
}
