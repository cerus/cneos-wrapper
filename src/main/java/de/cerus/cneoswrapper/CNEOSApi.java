package de.cerus.cneoswrapper;

import de.cerus.cneoswrapper.cad.CADApiClient;
import de.cerus.cneoswrapper.fireball.FireballApiClient;
import de.cerus.cneoswrapper.http.CNEOSHttpClient;

/**
 * A helper class for instantiating individual API wrappers.
 *
 * @author Maximilian Dorn
 */
public class CNEOSApi {

    private static final CNEOSHttpClient httpClient = new CNEOSHttpClient();

    private CNEOSApi() {
    }

    public static CADApiClient getNewCADApiClient() {
        return new CADApiClient(httpClient);
    }

    public static FireballApiClient getNewFireballApiClient() {
        return new FireballApiClient(httpClient);
    }

    public static void shutdown() {
        httpClient.shutdown();
    }

}
