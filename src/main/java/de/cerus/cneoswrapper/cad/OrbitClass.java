package de.cerus.cneoswrapper.cad;

/**
 * See https://ssd-api.jpl.nasa.gov/doc/cad.html#sbdb_class_table
 */
public enum OrbitClass {

    /**
     * Atira An asteroid orbit contained entirely within the orbit of the Earth (Q < 0.983 AU). Also known as an Interior Earth Object.
     */
    IEO,

    /**
     * Aten Near-Earth asteroid orbits similar to that of 2062 Aten (a < 1.0 AU; Q > 0.983 AU).
     */
    ATE,

    /**
     * Apollo Near-Earth asteroid orbits which cross the Earth’s orbit similar to that of 1862 Apollo (a > 1.0 AU; q < 1.017 AU).
     */
    APO,

    /**
     * Amor Near-Earth asteroid orbits similar to that of 1221 Amor (1.017 AU < q < 1.3 AU).
     */
    AMO,

    /**
     * Mars-crossing Asteroid Asteroids that cross the orbit of Mars constrained by (1.3 AU < q < 1.666 AU; a < 3.2 AU).
     */
    MCA,

    /**
     * Inner Main-belt Asteroid Asteroids with orbital elements constrained by (a < 2.0 AU; q > 1.666 AU).
     */
    IMB,

    /**
     * Main-belt Asteroid Asteroids with orbital elements constrained by (2.0 AU < a < 3.2 AU; q > 1.666 AU).
     */
    MBA,

    /**
     * Outer Main-belt Asteroid Asteroids with orbital elements constrained by (3.2 AU < a < 4.6 AU).
     */
    OMB,

    /**
     * Jupiter Trojan Asteroids trapped in Jupiter’s L4/L5 Lagrange points (4.6 AU < a < 5.5 AU; e < 0.3).
     */
    TJN,

    /**
     * Centaur Objects with orbits between Jupiter and Neptune (5.5 AU < a < 30.1 AU).
     */
    CEN,

    /**
     * TransNeptunian Object Objects with orbits outside Neptune (a > 30.1 AU).
     */
    TNO,

    /**
     * Parabolic Asteroid Asteroids on parabolic orbits (e = 1.0).
     */
    PAA,

    /**
     * Hyperbolic Asteroid Asteroids on hyperbolic orbits (e > 1.0).
     */
    HYA,

    /**
     * Hyperbolic Comet Comets on hyperbolic orbits (e > 1.0).
     */
    HYP,

    /**
     * Parabolic Comet Comets on parabolic orbits (e = 1.0).
     */
    PAR,

    /**
     * Comet Comet orbit not matching any defined orbit class.
     */
    COM,

    /**
     * Jupiter-family Comet* Jupiter-family comet, classical definition (P < 20 y).
     */
    JFC,

    /**
     * Halley-type Comet* Halley-type comet, classical definition (20 y < P < 200 y).
     */
    HTC,

    /**
     * Encke-type Comet Encke-type comet, as defined by Levison and Duncan (Tj > 3; a < aJ).
     */
    ETc,

    /**
     * Chiron-type Comet Chiron-type comet, as defined by Levison and Duncan (Tj > 3; a > aJ).
     */
    CTc,

    /**
     * Jupiter-family Comet Jupiter-family comet, as defined by Levison and Duncan (2 < Tj < 3).
     */
    JFc

}
