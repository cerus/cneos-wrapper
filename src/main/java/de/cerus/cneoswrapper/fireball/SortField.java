package de.cerus.cneoswrapper.fireball;

/**
 * Possible sorting fields for the Fireball API
 *
 * @author Maximilian Dorn
 */
public enum SortField {

    DATE("date"),
    ENERGY("energy"),
    IMPACT_E("impact-e"),
    VEL("vel"),
    ALT("alt");

    private final String field;

    SortField(final String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

}
