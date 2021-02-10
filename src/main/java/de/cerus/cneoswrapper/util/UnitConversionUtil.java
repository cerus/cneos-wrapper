package de.cerus.cneoswrapper.util;

/**
 * Simple utility for converting between AU and LD
 *
 * @author Maximilian Dorn
 */
public class UnitConversionUtil {

    /**
     * Astronomical unit (distance from sun to earth) in meters
     * 149,597,870,700 meters
     */
    public static double AU = 149597870700D;

    /**
     * Lunar distance (distance from moon to earth) in meters
     * 384,400,000 meters
     */
    public static double LD = 384400 * 1000D;

    /**
     * Convert AU to LD
     *
     * @param d The distance
     *
     * @return The converted distance
     */
    public static double astronomicalToLunar(final double d) {
        return (d * AU) / LD;
    }

    /**
     * Convert LD to AU
     *
     * @param d The distance
     *
     * @return The converted distance
     */
    public static double lunarToAstronomical(final double d) {
        return (d * LD) / AU;
    }

}
