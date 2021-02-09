package de.cerus.cneoswrapper.cad;

import de.cerus.cneoswrapper.http.ApiResponse;
import de.cerus.cneoswrapper.http.CNEOSHttpClient;
import de.cerus.cneoswrapper.query.Query;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;
import okhttp3.Request;
import okhttp3.Response;

public class CADApiClient {

    private final CNEOSHttpClient httpClient;

    public CADApiClient(final CNEOSHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CompletableFuture<ApiResponse<List<CloseApproachData>>> retrieveCloseApproachDataAsync(final Query query) {
        return this.httpClient.executeAsync(new Request.Builder()
                .url("https://ssd-api.jpl.nasa.gov/cad.api" + query.buildQueryString(true))
                .get()
                .build()).thenApply(response -> {
            final String payload;
            try {
                payload = response.body().string();
            } catch (final IOException e) {
                throw new CompletionException(e);
            }

            switch (response.code()) {
                case 400:
                    return new ApiResponse<>(null, new IllegalStateException("Server returned status 400 (bad request)"));
                case 500:
                    return new ApiResponse<>(null, new IllegalStateException("Server returned status 500 (internal server error)"));
                case 503:
                    return new ApiResponse<>(null, new IllegalStateException("Server returned status 503 (service unavailable)"));
            }

            return new ApiResponse<>(this.httpClient.parseResponse(payload).stream()
                    .map(CloseApproachData::new)
                    .collect(Collectors.toList()), null);
        });
    }

    public ApiResponse<List<CloseApproachData>> retrieveCloseApproachData(final Query query) {
        final Response response;
        final String payload;
        try {
            response = this.httpClient.executeSync(new Request.Builder()
                    .url("https://ssd-api.jpl.nasa.gov/cad.api" + query.buildQueryString(true))
                    .get()
                    .build());
            payload = response.body().string();
        } catch (final IOException e) {
            return new ApiResponse<>(null, e);
        }

        switch (response.code()) {
            case 400:
                return new ApiResponse<>(null, new IllegalStateException("Server returned status 400 (bad request)"));
            case 500:
                return new ApiResponse<>(null, new IllegalStateException("Server returned status 500 (internal server error)"));
            case 503:
                return new ApiResponse<>(null, new IllegalStateException("Server returned status 503 (service unavailable)"));
        }

        return new ApiResponse<>(this.httpClient.parseResponse(payload).stream()
                .map(CloseApproachData::new)
                .collect(Collectors.toList()), null);
    }

}
