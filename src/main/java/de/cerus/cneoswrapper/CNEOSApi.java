package de.cerus.cneoswrapper;

import de.cerus.cneoswrapper.cad.CADApiClient;
import de.cerus.cneoswrapper.http.CNEOSHttpClient;
import de.cerus.cneoswrapper.util.UnitConversionUtil;

public class CNEOSApi {

    private static final CNEOSHttpClient httpClient = new CNEOSHttpClient();

    private CNEOSApi() {
    }

    public static CADApiClient getNewCADApiClient() {
        return new CADApiClient(httpClient);
    }

    public static void main(final String[] args) {
        System.out.println(UnitConversionUtil.astronomicalToLunar(1));
        System.out.println(UnitConversionUtil.lunarToAstronomical(1));
    }

}
