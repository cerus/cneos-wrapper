package de.cerus.cneoswrapper.cad;

/**
 * Possible sorting fields for the CAD API
 *
 * @author Maximilian Dorn
 */
public enum SortField {

    DATE("date"),
    DIST("dist"),
    DIST_MIN("dist-min"),
    V_INF("v-inf"),
    V_REL("v-rel"),
    H("h"),
    OBJECT("object");

    private final String field;

    SortField(final String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;

    }
}
