package de.cerus.cneoswrapper.cad;

public enum Body {

    MERCURY("Merc"),
    VENUS("Venus"),
    EARTH("Earth"),
    MARS("Mars"),
    JUPITER("Juptr"),
    SATURN("Satrn"),
    URANUS("Urnus"),
    NEPTUN("Neptn"),
    PLUTO("Pluto"),
    MOON("Moon"),
    ALL("*");

    private final String name;

    Body(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
