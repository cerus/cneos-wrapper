package de.cerus.cneoswrapper.util;

public class NumberUtil {

    private NumberUtil() {
    }

    public static Double parseDouble(final String s) {
        try {
            return Double.parseDouble(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

    public static Integer parseInt(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

    public static Long parseLong(final String s) {
        try {
            return Long.parseLong(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

}
