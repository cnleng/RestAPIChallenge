package com.cnleng.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
    private static final int ONE_DAY = 1;
//    2020-12-28 12:12:12

    public static DateTime convertToDateTime(String stringDateTime) {
        if (stringDateTime != null) {
            return FORMATTER.parseDateTime(stringDateTime);
        }
        return null;
    }

    public static String convertFromDateTime(DateTime dateTime) {
        if (dateTime != null) {
            return FORMATTER.print(dateTime);
        }
        return null;
    }

    public static int getDifferenceInDays(DateTime start, DateTime end) {
        return Days.daysBetween(start.toLocalDate(), end.toLocalDate()).getDays();
    }

    public static DateTime getDefaultCheckIn() {
        DateTime now = DateTime.now();
        String s = FORMATTER.print(now);
        return FORMATTER.parseDateTime(s).plusDays(ONE_DAY);
    }

    public static DateTime getMonthAhead(DateTime current, int numberOfMonths) {
        if (current == null) {
            current = FORMATTER.parseDateTime(FORMATTER.print(DateTime.now()));
        }
        return current.plusMonths(numberOfMonths);
    }

    public static boolean isValidDateRange(DateTime start, DateTime end) {
        if (start != null && end != null) {
            return start.isBefore(end);
        }
        return false;
    }
}
