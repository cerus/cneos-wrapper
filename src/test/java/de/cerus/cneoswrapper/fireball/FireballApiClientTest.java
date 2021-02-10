package de.cerus.cneoswrapper.fireball;

import de.cerus.cneoswrapper.CNEOSApi;
import de.cerus.cneoswrapper.http.ApiResponse;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FireballApiClientTest {

    @Test
    @DisplayName("Results should not be empty")
    public void testFireballApiClient() {
        final FireballApiClient client = CNEOSApi.getNewFireballApiClient();
        final ApiResponse<List<Fireball>> data = client.retrieveFireballs(new FireballQueryBuilder()
                .sort(SortField.DATE, true)
                .build());
        Assumptions.assumeTrue(data.getError() == null); // Disable test if the server returns an error for a valid request
        Assertions.assertFalse(data.getData().isEmpty());
    }

}
