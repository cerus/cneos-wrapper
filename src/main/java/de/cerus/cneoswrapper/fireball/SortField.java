package de.cerus.cneoswrapper.fireball;

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
