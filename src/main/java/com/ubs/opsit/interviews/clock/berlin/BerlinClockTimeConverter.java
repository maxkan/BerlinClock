package com.ubs.opsit.interviews.clock.berlin;

import com.ubs.opsit.interviews.Time;
import com.ubs.opsit.interviews.TimeConverter;

import static java.lang.System.lineSeparator;

public class BerlinClockTimeConverter implements TimeConverter {

    private final HoursConverter hoursConverter;
    private final MinutesConverter minutesConverter;
    private final SecondsConverter secondsConverter;

    public BerlinClockTimeConverter() {
        hoursConverter = new HoursConverter();
        minutesConverter = new MinutesConverter();
        secondsConverter = new SecondsConverter();
    }

    @Override
    public String convertTime(String aTime) {
        Time time = new Time(aTime);

        return secondsConverter.convert(time) + lineSeparator()
                + hoursConverter.convert(time) + lineSeparator()
                + minutesConverter.convert(time);
    }
}
