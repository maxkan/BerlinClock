package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;

import static java.lang.System.lineSeparator;

public class HoursConverter {

    private static final int FOUR_BULBS = 4;
    private static final int ONE_HOUR_PER_BULB = 1;
    private static final int FIVE_HOURS_PER_BULB = 5;
    private static final int EACH_BULB_IS_SIGNIFICANT = 1;

    private UnitsToBulbRowConverter topRow;
    private UnitsToBulbRowConverter bottomRow;

    public HoursConverter() {
        topRow = new UnitsToBulbRowConverter(FOUR_BULBS, FIVE_HOURS_PER_BULB, EACH_BULB_IS_SIGNIFICANT);
        bottomRow = new UnitsToBulbRowConverter(FOUR_BULBS, ONE_HOUR_PER_BULB, EACH_BULB_IS_SIGNIFICANT);
    }

    public String convert(Time time) {
        if (time == null) {
            throw new IllegalArgumentException("Time must not be null");
        }

        int hourOfDay = time.getHours();
        int hoursForTheBottomRow = hourOfDay % FIVE_HOURS_PER_BULB;
        int hoursForTheTopRow = hourOfDay - hoursForTheBottomRow;

        return topRow.convert(hoursForTheTopRow) + lineSeparator() + bottomRow.convert(hoursForTheBottomRow);
    }
}
