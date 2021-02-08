package de.cerus.cneoswrapper.cad;

import de.cerus.cneoswrapper.CNEOSApi;
import de.cerus.cneoswrapper.http.ApiResponse;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CADApiClientTest {

    @Test
    @DisplayName("Results should not be empty")
    public void testCADApiClient() {
        final CADApiClient client = CNEOSApi.getNewCADApiClient();
        final ApiResponse<List<CloseApproachData>> data = client.retrieveCloseApproachData(new CADQueryBuilder()
                .body(Body.ALL)
                .build());
        Assumptions.assumeTrue(data.getError() == null); // Disable test if the server returns an error for a valid request
        Assertions.assertFalse(data.getData().isEmpty());
    }

}
