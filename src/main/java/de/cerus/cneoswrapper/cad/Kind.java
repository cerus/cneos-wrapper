package de.cerus.cneoswrapper.cad;

/**
 * Possible object kinds
 *
 * @author Maximilian Dorn
 */
public enum Kind {

    ASTEROID("a"),
    NUMBERED_ASTEROID("an"),
    UNNUMBERED_ASTEROID("au"),
    COMETS("c"),
    NUMBERED_COMETS("cn"),
    UNNUMBERED_COMETS("cu"),
    NUMBERED_OBJECTS("n"),
    UNNUMBERED_OBJECTS("u");

    private final String paramVal;

    Kind(final String paramVal) {
        this.paramVal = paramVal;
    }

    public String getParamVal() {
        return this.paramVal;
    }

}
