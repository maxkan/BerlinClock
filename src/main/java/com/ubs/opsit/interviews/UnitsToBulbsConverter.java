package com.ubs.opsit.interviews;

/**
 * Created by Max on 3/10/2015.
 */
public class UnitsToBulbsConverter {
    private static final int NO_SIGNIFICANT_BULBS = -1;

    private final int numberOfBulbs;
    private final int unitAmountPerBulb;
    private final int significantIndexStep;

    public UnitsToBulbsConverter(int numberOfBulbs, int unitAmountPerBulb, int significantIndexStep) {
        this.numberOfBulbs = numberOfBulbs;
        this.unitAmountPerBulb = unitAmountPerBulb;
        this.significantIndexStep = significantIndexStep;
    }

    public UnitsToBulbsConverter(int numberOfBulbs, int unitAmountPerBulb) {
        this(numberOfBulbs, unitAmountPerBulb, NO_SIGNIFICANT_BULBS);
    }

    public String convert(int value) {
        StringBuilder result = new StringBuilder(numberOfBulbs);

        int bulbsCount = value / unitAmountPerBulb;
        for (int i = 0; i < bulbsCount; i++) {
            result.append(getBulb(i));
        }

        for (int j = bulbsCount; j < numberOfBulbs; j++) {
            result.append('O');
        }

        return result.toString();
    }

    private char getBulb(int index) {
        return isSignificant(index) ? 'R' : 'Y';
    }

    private boolean isSignificant(int bulbIndex) {
        if (significantIndexStep == NO_SIGNIFICANT_BULBS) {
            return false;
        }
        return (bulbIndex + 1) % significantIndexStep == 0;
    }
}
