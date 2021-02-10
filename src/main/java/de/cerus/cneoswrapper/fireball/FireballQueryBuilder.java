package de.cerus.cneoswrapper.fireball;

import de.cerus.cneoswrapper.query.Query;
import de.cerus.cneoswrapper.query.QueryTime;

public class FireballQueryBuilder {

    private final Query query = new Query();

    /**
     * Minimum date and time
     * Excludes fireballs earlier than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public FireballQueryBuilder minDate(final QueryTime time) {
        return this.from(time);
    }

    /**
     * Minimum date and time
     * Excludes fireballs earlier than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public FireballQueryBuilder from(final QueryTime time) {
        this.query.putParam("date-min", time.toString());
        return this;
    }

    /**
     * Maximum date and time
     * Excludes fireballs later than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public FireballQueryBuilder maxDate(final QueryTime time) {
        return this.until(time);
    }

    /**
     * Maximum date and time
     * Excludes fireballs later than the specified date and time.
     *
     * @param time Date and time
     *
     * @return The builder instance
     */
    public FireballQueryBuilder until(final QueryTime time) {
        this.query.putParam("date-max", time.toString());
        return this;
    }

    /**
     * Exclude data with total-radiated-energy less than this positive value in joules ×10^10 (e.g., 0.3 = 0.3×10^10 joules)
     *
     * @param e The energy
     *
     * @return The builder instance
     */
    public FireballQueryBuilder energyMin(final double e) {
        this.query.putParam("energy-min", String.valueOf(e));
        return this;
    }

    /**
     * Exclude data with total-radiated-energy greater than this positive value in joules ×10^10 (e.g., 0.3 = 0.3×10^10 joules)
     *
     * @param e The energy
     *
     * @return The builder instance
     */
    public FireballQueryBuilder energyMax(final double e) {
        this.query.putParam("energy-max", String.valueOf(e));
        return this;
    }

    /**
     * Exclude data with estimated impact energy less than this positive value in kilotons (kt) (e.g., 0.08 kt)
     *
     * @param e The energy
     *
     * @return The builder instance
     */
    public FireballQueryBuilder impactEnergyMin(final double e) {
        this.query.putParam("impact-e-min", String.valueOf(e));
        return this;
    }

    /**
     * Exclude data with estimated impact energy greater than this positive value in kilotons (kt) (e.g., 0.08 kt)
     *
     * @param e The energy
     *
     * @return The builder instance
     */
    public FireballQueryBuilder impactEnergyMax(final double e) {
        this.query.putParam("impact-e-max", String.valueOf(e));
        return this;
    }

    /**
     * Exclude data with velocity-at-peak-brightness less than this positive value in km/s (e.g., 18.5)
     *
     * @param v The velocity
     *
     * @return The builder instance
     */
    public FireballQueryBuilder velocityMin(final double v) {
        this.query.putParam("vel-min", String.valueOf(v));
        return this;
    }

    /**
     * Exclude data with velocity-at-peak-brightness greater than this positive value in km/s (e.g., 18.5)
     *
     * @param v The velocity
     *
     * @return The builder instance
     */
    public FireballQueryBuilder velocityMax(final double v) {
        this.query.putParam("vel-max", String.valueOf(v));
        return this;
    }

    /**
     * Exclude data from objects with an altitude less than this (e.g., 22 meaning objects smaller than this)
     *
     * @param a The altitude
     *
     * @return The builder instance
     */
    public FireballQueryBuilder altitudeMin(final double a) {
        this.query.putParam("alt-min", String.valueOf(a));
        return this;
    }

    /**
     * Exclude data from objects with an altitude greater than this (e.g., 17.75 meaning objects larger than this)
     *
     * @param a The altitude
     *
     * @return The builder instance
     */
    public FireballQueryBuilder altitudeMax(final double a) {
        this.query.putParam("alt-max", String.valueOf(a));
        return this;
    }

    /**
     * Exclude data without a location
     *
     * @return The builder instance
     */
    public FireballQueryBuilder locationRequired() {
        this.query.putParam("req-loc", "true");
        return this;
    }

    /**
     * Exclude data without an altitude
     *
     * @return The builder instance
     */
    public FireballQueryBuilder altitudeRequired() {
        this.query.putParam("req-alt", "true");
        return this;
    }

    /**
     * Exclude data without a velocity
     *
     * @return The builder instance
     */
    public FireballQueryBuilder velocityRequired() {
        this.query.putParam("req-vel", "true");
        return this;
    }

    /**
     * Exclude data without velocity components
     *
     * @return The builder instance
     */
    public FireballQueryBuilder velocityComponentsRequired() {
        this.query.putParam("req-vel-comp", "true");
        return this;
    }

    /**
     * Include velocity components
     *
     * @return The builder instance
     */
    public FireballQueryBuilder includeVelocityComponents() {
        this.query.putParam("vel-comp", "true");
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
    public FireballQueryBuilder sort(final SortField sortField, final boolean descending) {
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
    public FireballQueryBuilder limit(final int limit) {
        this.query.putParam("limit", String.valueOf(limit));
        return this;
    }

    public Query build() {
        return this.query;
    }

}
