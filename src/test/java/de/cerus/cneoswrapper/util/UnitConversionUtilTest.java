package de.cerus.cneoswrapper.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnitConversionUtilTest {

    @Test
    @DisplayName("AU -> LD")
    public void testAstronomicalToLunarConversion() {
        Assertions.assertEquals(1, UnitConversionUtil.astronomicalToLunar(UnitConversionUtil.lunarToAstronomical(1)));
    }

    @Test
    @DisplayName("LD -> AU")
    public void testLunarToAstronomicalConversion() {
        Assertions.assertEquals(1, UnitConversionUtil.lunarToAstronomical(UnitConversionUtil.astronomicalToLunar(1)));
    }

}
