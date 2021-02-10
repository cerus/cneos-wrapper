package de.cerus.cneoswrapper.fireball;

import de.cerus.cneoswrapper.util.NumberUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    public Fireball(final Date date,
                    final Double latitude,
                    final Double longitude,
                    final String latitudeDirection,
                    final String longitudeDirection,
                    final Double altitude,
                    final Double velocityAtPeak,
                    final double energy,
                    final double impactEnergy,
                    final Double velocityX,
                    final Double velocityY,
                    final Double velocityZ) {
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

    public Date getDate() {
        return this.date;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getLatitudeDirection() {
        return this.latitudeDirection;
    }

    public String getLongitudeDirection() {
        return this.longitudeDirection;
    }

    public Double getAltitude() {
        return this.altitude;
    }

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

    public Double getVelocityX() {
        return this.velocityX;
    }

    public Double getVelocityY() {
        return this.velocityY;
    }

    public Double getVelocityZ() {
        return this.velocityZ;
    }

}
