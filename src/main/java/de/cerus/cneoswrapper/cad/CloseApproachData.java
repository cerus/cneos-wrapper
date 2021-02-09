package de.cerus.cneoswrapper.cad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CloseApproachData {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MMM-dd HH:mm");

    private final String designation;
    private final int orbitId;
    private final String julianDate;
    private final Date calendarDate;
    private final double distance;
    private final double distanceMin;
    private final double distanceMax;
    private final double velocityInfinite;
    private final double velocityRelative;
    private final String threeSigmaUncertainty;
    private final Body body;
    private final double absMagnitude;
    private final String fullName;

    public CloseApproachData(final Map<String, String> rawData) {
        this(rawData.get("des"),
                Integer.parseInt(rawData.get("orbit_id")),
                rawData.get("jd"),
                parseDate(rawData.get("cd")),
                Double.parseDouble(rawData.get("dist")),
                Double.parseDouble(rawData.get("dist_min")),
                Double.parseDouble(rawData.get("dist_max")),
                Double.parseDouble(rawData.get("v_inf")),
                Double.parseDouble(rawData.get("v_rel")),
                rawData.get("t_sigma_f"),
                Body.valueOf(rawData.getOrDefault("body", "Earth").toUpperCase()),
                Double.parseDouble(rawData.get("h")),
                rawData.getOrDefault("fullname", null));
    }

    public CloseApproachData(final String designation,
                             final int orbitId,
                             final String julianDate,
                             final Date calendarDate,
                             final double distance,
                             final double distanceMin,
                             final double distanceMax,
                             final double velocityInfinite,
                             final double velocityRelative,
                             final String threeSigmaUncertainty,
                             final Body body,
                             final double absMagnitude,
                             final String fullName) {
        this.designation = designation;
        this.orbitId = orbitId;
        this.julianDate = julianDate;
        this.calendarDate = calendarDate;
        this.distance = distance;
        this.distanceMin = distanceMin;
        this.distanceMax = distanceMax;
        this.velocityInfinite = velocityInfinite;
        this.velocityRelative = velocityRelative;
        this.threeSigmaUncertainty = threeSigmaUncertainty;
        this.body = body;
        this.absMagnitude = absMagnitude;
        this.fullName = fullName;
    }

    private static Date parseDate(final String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (final ParseException e) {
            return null;
        }
    }

    public String getDesignation() {
        return this.designation;
    }

    public int getOrbitId() {
        return this.orbitId;
    }

    public String getJulianDate() {
        return this.julianDate;
    }

    public Date getCalendarDate() {
        return this.calendarDate;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getDistanceMin() {
        return this.distanceMin;
    }

    public double getDistanceMax() {
        return this.distanceMax;
    }

    public double getVelocityInfinite() {
        return this.velocityInfinite;
    }

    public double getVelocityRelative() {
        return this.velocityRelative;
    }

    public String getThreeSigmaUncertainty() {
        return this.threeSigmaUncertainty;
    }

    public Body getBody() {
        return this.body;
    }

    public double getAbsMagnitude() {
        return this.absMagnitude;
    }

    public String getFullName() {
        return this.fullName;
    }

}
