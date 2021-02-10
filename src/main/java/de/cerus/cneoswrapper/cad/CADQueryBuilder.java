package de.cerus.cneoswrapper.cad;

import de.cerus.cneoswrapper.query.Query;
import de.cerus.cneoswrapper.query.QueryTime;

/**
 * A helper method for creating CAD API queries
 *
 * @author Maximilian Dorn
 */
public class CADQueryBuilder {

    private final Query query = new Query();

    /**
     * Minimum date and time
     * Excludes close approaches earlier than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public CADQueryBuilder minDate(final QueryTime time) {
        return this.from(time);
    }

    /**
     * Minimum date and time
     * Excludes close approaches earlier than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public CADQueryBuilder from(final QueryTime time) {
        this.query.putParam("date-min", time.toString());
        return this;
    }

    /**
     * Maximum date and time
     * Excludes close approaches later than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public CADQueryBuilder maxDate(final QueryTime time) {
        return this.until(time);
    }

    /**
     * Maximum date and time
     * Excludes close approaches later than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public CADQueryBuilder until(final QueryTime time) {
        this.query.putParam("date-max", time.toString());
        return this;
    }

    /**
     * Minimum distance in au (astronomical unit (distance of earth to sun))
     *
     * @param dist Distance in au
     *
     * @return The builder instance
     */
    public CADQueryBuilder distanceMin(final double dist) {
        this.query.putParam("dist-min", String.valueOf(dist));
        return this;
    }

    /**
     * Minimum distance in LD (lunar distance (distance of earth to moon))
     *
     * @param dist Distance in LD
     *
     * @return The builder instance
     */
    public CADQueryBuilder distanceMinLunar(final double dist) {
        this.query.putParam("dist-min", dist + "LD");
        return this;
    }

    /**
     * Maximum distance in au (astronomical unit (distance of earth to sun))
     *
     * @param dist Distance in au
     *
     * @return The builder instance
     */
    public CADQueryBuilder distanceMax(final double dist) {
        this.query.putParam("dist-max", String.valueOf(dist));
        return this;
    }

    /**
     * Maximum distance in LD (lunar distance (distance of earth to moon))
     *
     * @param dist Distance in LD
     *
     * @return The builder instance
     */
    public CADQueryBuilder distanceMaxLunar(final double dist) {
        this.query.putParam("dist-max", dist + "LD");
        return this;
    }

    /**
     * Minimum absolute magnitude
     * Excludes data with H-values less than this.
     *
     * @param mag Absolute magnitude
     *
     * @return The builder instance
     */
    public CADQueryBuilder absMagMin(final double mag) {
        this.query.putParam("h-min", String.valueOf(mag));
        return this;
    }

    /**
     * Minimum absolute magnitude
     * Excludes data with H-values less than this.
     *
     * @param mag Absolute magnitude
     *
     * @return The builder instance
     */
    public CADQueryBuilder hMin(final double mag) {
        return this.absMagMin(mag);
    }

    /**
     * Maximum absolute magnitude
     * Excludes data with H-values greater than this.
     *
     * @param mag Absolute magnitude
     *
     * @return The builder instance
     */
    public CADQueryBuilder absMagMax(final double mag) {
        this.query.putParam("h-max", String.valueOf(mag));
        return this;
    }

    /**
     * Maximum absolute magnitude
     * Excludes data with H-values greater than this.
     *
     * @param mag Absolute magnitude
     *
     * @return The builder instance
     */
    public CADQueryBuilder hMax(final double mag) {
        return this.absMagMax(mag);
    }

    /**
     * Minimum infinite velocity (relative to a massless earth)
     *
     * @param v Positive infinite velocity
     *
     * @return The builder instance
     */
    public CADQueryBuilder infiniteVelocityMin(final double v) {
        this.query.putParam("v-inf-min", String.valueOf(v));
        return this;
    }

    /**
     * Maximum infinite velocity (relative to a massless earth)
     *
     * @param v Positive infinite velocity
     *
     * @return The builder instance
     */
    public CADQueryBuilder infiniteVelocityMax(final double v) {
        this.query.putParam("v-inf-max", String.valueOf(v));
        return this;
    }

    /**
     * Minimum infinite velocity (relative to earth)
     *
     * @param v Positive relative velocity
     *
     * @return The builder instance
     */
    public CADQueryBuilder relativeVelocityMin(final double v) {
        this.query.putParam("v-rel-min", String.valueOf(v));
        return this;
    }

    /**
     * Maximum infinite velocity (relative earth)
     *
     * @param v Positive relative velocity
     *
     * @return The builder instance
     */
    public CADQueryBuilder relativeVelocityMax(final double v) {
        this.query.putParam("v-rel-max", String.valueOf(v));
        return this;
    }

    /**
     * Limit to a specific orbit class
     *
     * @param clazz The orbit class
     *
     * @return The builder instance
     */
    public CADQueryBuilder orbitClass(final OrbitClass clazz) {
        this.query.putParam("class", clazz.name());
        return this;
    }

    /**
     * Limit data to only NEAs (near earth asteroids)
     *
     * @return The builder instance
     */
    public CADQueryBuilder onlyNEAs() {
        this.query.putParam("nea", "true");
        return this;
    }

    /**
     * Limit data to only comets
     *
     * @return The builder instance
     */
    public CADQueryBuilder onlyComets() {
        this.query.putParam("comet", "true");
        return this;
    }

    /**
     * Limit data to only comets and NEAs
     *
     * @return The builder instance
     */
    public CADQueryBuilder onlyCometsAndNEAs() {
        this.query.putParam("nea-comet", "true");
        return this;
    }

    /**
     * Limit data to only PHAs (potentially hazardous asteroids)
     *
     * @return The builder instance
     */
    public CADQueryBuilder onlyPHAs() {
        this.query.putParam("pha", "true");
        return this;
    }

    /**
     * Limit data to only NEOs (near earth objects)
     *
     * @return The builder instance
     */
    public CADQueryBuilder onlyNEOs() {
        this.query.putParam("neo", "true");
        return this;
    }

    /**
     * Limit data to a specific kind
     *
     * @param kind The object kind
     *
     * @return The builder instance
     */
    public CADQueryBuilder kind(final Kind kind) {
        this.query.putParam("kind", kind.getParamVal());
        return this;
    }

    /**
     * Limit data to a specific SPK ID
     *
     * @param spkId The SPK-ID
     *
     * @return The builder instance
     */
    public CADQueryBuilder spk(final int spkId) {
        this.query.putParam("spk", String.valueOf(spkId));
        return this;
    }

    /**
     * Limit data to a specific designation
     *
     * @param des The designation
     *
     * @return The builder instance
     */
    public CADQueryBuilder designation(final String des) {
        this.query.putParam("des", des);
        return this;
    }

    /**
     * Limit data to a specific body
     *
     * @param body A specific body
     *
     * @return The builder instance
     */
    public CADQueryBuilder body(final Body body) {
        this.query.putParam("body", body.getName());
        return this;
    }

    /**
     * Sort by the specific field
     *
     * @param sortField  The field to sort by
     * @param descending Descending or not
     *
     * @return The builder instance
     */
    public CADQueryBuilder sort(final SortField sortField, final boolean descending) {
        this.query.putParam("sort", (descending ? "-" : "") + sortField.getField());
        return this;
    }

    /**
     * Limit to N results
     *
     * @param limit The limit
     *
     * @return The builder instance
     */
    public CADQueryBuilder limit(final int limit) {
        this.query.putParam("limit", String.valueOf(limit));
        return this;
    }

    /**
     * Include full format object name / designation
     *
     * @return The builder instance
     */
    public CADQueryBuilder fullName() {
        this.query.putParam("fullname", "true");
        return this;
    }

    public Query build() {
        return this.query;
    }

}
