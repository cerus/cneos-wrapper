package de.cerus.cneoswrapper.query;

import java.util.Calendar;
import java.util.Date;

public class QueryTime {

    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minutes;
    private final int seconds;

    public QueryTime() {
        this(new Date());
    }

    public QueryTime(final Date date) {
        this(getCalender(date));
    }

    public QueryTime(final Calendar calendar) {
        this(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
    }

    public QueryTime(final long millis) {
        this(new Date(millis));
    }

    public QueryTime(final int year, final int month, final int day) {
        this(year, month, day, 0, 0, 0);
    }

    public QueryTime(final int year, final int month, final int day, final int hour, final int minutes, final int seconds) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;

        this.validate();
    }

    private static Calendar getCalender(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private void validate() {
        if (this.year < 1 || this.month < 1 || this.month > 12 || this.day < 1 || this.day > 31 || this.hour < 0
                || this.hour > 24 || this.minutes < 0 || this.minutes > 60 || this.seconds < 0 || this.seconds > 60) {
            throw new IllegalStateException("Invalid date / time");
        }
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%04d", this.year)).append("-")
                .append(String.format("%02d", this.month)).append("-")
                .append(String.format("%02d", this.day));
        if (this.hour != 0 || this.minutes != 0 || this.seconds != 0) {
            stringBuilder.append("T")
                    .append(String.format("%02d", this.hour)).append(":")
                    .append(String.format("%02d", this.minutes)).append(":")
                    .append(String.format("%02d", this.seconds));
        }
        return stringBuilder.toString();
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

}
