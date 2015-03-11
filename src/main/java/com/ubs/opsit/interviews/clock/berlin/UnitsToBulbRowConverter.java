package com.ubs.opsit.interviews.clock.berlin;

public class UnitsToBulbRowConverter {

    private final int numberOfBulbs;
    private final int unitAmountPerBulb;
    private final Integer significantIndexStep;

    public UnitsToBulbRowConverter(int numberOfBulbs, int unitAmountPerBulb, Integer significantIndexStep) {
        this.numberOfBulbs = numberOfBulbs;
        this.unitAmountPerBulb = unitAmountPerBulb;
        this.significantIndexStep = significantIndexStep;
    }

    public UnitsToBulbRowConverter(int numberOfBulbs, int unitAmountPerBulb) {
        this(numberOfBulbs, unitAmountPerBulb, null);
    }

    public String convert(int units) {
        StringBuilder result = new StringBuilder(numberOfBulbs);

        int bulbsCount = units / unitAmountPerBulb;
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
        if (significantIndexStep == null) {
            return false;
        }
        return (bulbIndex + 1) % significantIndexStep == 0;
    }
}
