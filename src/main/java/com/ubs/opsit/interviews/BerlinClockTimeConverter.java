package com.ubs.opsit.interviews;

/**
 * Created by Max on 3/10/2015.
 */
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

        return secondsConverter.convert(time.getSeconds()) + System.lineSeparator()
                + hoursConverter.convert(time.getHours()) + System.lineSeparator()
                + minutesConverter.convert(time.getMinutes());
    }
}
