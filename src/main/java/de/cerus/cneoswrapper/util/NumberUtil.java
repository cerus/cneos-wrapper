package de.cerus.cneoswrapper.util;

/**
 * Simple utility to parse numbers without having to handle exceptions.
 *
 * @author Maximilian Dorn
 */
public class NumberUtil {

    // Restrict instantiation for util classes
    private NumberUtil() {
    }

    /**
     * Parse a double
     *
     * @param s The string to parse
     *
     * @return A parsed double or null
     */
    public static Double parseDouble(final String s) {
        try {
            return Double.parseDouble(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

    /**
     * Parse an integer
     *
     * @param s The string to parse
     *
     * @return A parsed integer or null
     */
    public static Integer parseInt(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

    /**
     * Parse a long
     *
     * @param s The string to parse
     *
     * @return A parsed long or null
     */
    public static Long parseLong(final String s) {
        try {
            return Long.parseLong(s);
        } catch (final Exception ignored) {
            return null;
        }
    }

}
