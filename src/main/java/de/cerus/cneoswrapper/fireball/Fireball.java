package de.cerus.cneoswrapper.fireball;

import de.cerus.cneoswrapper.util.NumberUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/**
 * Represents Fireball data
 *
 * @author Maximilian Dorn
 */
public class Fireball {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final Date date;
    private final Double latitude;
    private final Double longitude;
    private final String latitudeDirection;
    private final String longitudeDirection;
    private final Double altitude;
    private final Double velocityAtPeak;
    private final double energy;
    private final double impactEnergy;
    private final Double velocityX;
    private final Double velocityY;
    private final Double velocityZ;

    public Fireball(final Map<String, String> rawData) {
        this(parseDate(rawData.get("date")),
                NumberUtil.parseDouble(rawData.get("lat")),
                NumberUtil.parseDouble(rawData.get("lon")),
                rawData.get("lat-dir"),
                rawData.get("lon-dir"),
                NumberUtil.parseDouble(rawData.get("alt")),
                NumberUtil.parseDouble(rawData.get("vel")),
                Double.parseDouble(rawData.get("energy")),
                Double.parseDouble(rawData.get("impact-e")),
                NumberUtil.parseDouble(rawData.get("vx")),
                NumberUtil.parseDouble(rawData.get("vy")),
                NumberUtil.parseDouble(rawData.get("vz")));
    }

    public Fireball(@Nullable final Date date,
                    @Nullable final Double latitude,
                    @Nullable final Double longitude,
                    @Nullable final String latitudeDirection,
                    @Nullable final String longitudeDirection,
                    @Nullable final Double altitude,
                    @Nullable final Double velocityAtPeak,
                    final double energy,
                    final double impactEnergy,
                    @Nullable final Double velocityX,
                    @Nullable final Double velocityY,
                    @Nullable final Double velocityZ) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latitudeDirection = latitudeDirection;
        this.longitudeDirection = longitudeDirection;
        this.altitude = altitude;
        this.velocityAtPeak = velocityAtPeak;
        this.energy = energy;
        this.impactEnergy = impactEnergy;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    private static Date parseDate(final String date) {
        if (date == null) {
            return null;
        }

        try {
            return DATE_FORMAT.parse(date);
        } catch (final ParseException e) {
            return null;
        }
    }

    @Nullable
    public Date getDate() {
        return this.date;
    }

    @Nullable
    public Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public String getLatitudeDirection() {
        return this.latitudeDirection;
    }

    @Nullable
    public String getLongitudeDirection() {
        return this.longitudeDirection;
    }

    @Nullable
    public Double getAltitude() {
        return this.altitude;
    }

    @Nullable
    public Double getVelocityAtPeak() {
        return this.velocityAtPeak;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getRealEnergy() {
        return this.energy * Math.pow(10, 10);
    }

    public double getImpactEnergy() {
        return this.impactEnergy;
    }

    @Nullable
    public Double getVelocityX() {
        return this.velocityX;
    }

    @Nullable
    public Double getVelocityY() {
        return this.velocityY;
    }

    @Nullable
    public Double getVelocityZ() {
        return this.velocityZ;
    }

}
