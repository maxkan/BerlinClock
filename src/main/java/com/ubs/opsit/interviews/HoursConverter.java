package com.ubs.opsit.interviews;

public class HoursConverter {
    private static final int FOUR_BULBS = 4;
    private static final int ONE_HOUR_PER_BULB = 1;
    private static final int FIVE_HOURS_PER_BULB = 5;
    private static final int EACH_BULB_IS_SIGNIFICANT = 1;

    private UnitsToBulbsConverter topRowUnitConverter;
    private UnitsToBulbsConverter bottomRowUnitConverter;

    public HoursConverter() {
        topRowUnitConverter = new UnitsToBulbsConverter(FOUR_BULBS, FIVE_HOURS_PER_BULB, EACH_BULB_IS_SIGNIFICANT);
        bottomRowUnitConverter = new UnitsToBulbsConverter(FOUR_BULBS, ONE_HOUR_PER_BULB, EACH_BULB_IS_SIGNIFICANT);
    }

    public String convert(int hourOfDay) {
        int hoursForTheBottomRow = hourOfDay % FIVE_HOURS_PER_BULB;
        int hoursForTheTopRow = hourOfDay - hoursForTheBottomRow;

        return topRowUnitConverter.convert(hoursForTheTopRow) + System.lineSeparator()
                + bottomRowUnitConverter.convert(hoursForTheBottomRow);
    }
}
