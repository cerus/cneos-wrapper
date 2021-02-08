package de.cerus.cneoswrapper.http;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CNEOSHttpClient {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final OkHttpClient httpClient;

    public CNEOSHttpClient() {
        this(new OkHttpClient());
    }

    public CNEOSHttpClient(final OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response executeSync(final Request request) throws IOException {
        return this.httpClient.newCall(request).execute();
    }

    public CompletableFuture<Response> executeAsync(final Request request) {
        final CompletableFuture<Response> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            try {
                future.complete(this.httpClient.newCall(request).execute());
            } catch (final IOException e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }

    public void shutdown() {
        this.executorService.shutdown();
    }

}
