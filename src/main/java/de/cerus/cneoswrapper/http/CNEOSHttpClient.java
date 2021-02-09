package de.cerus.cneoswrapper.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

    public List<Map<String, String>> parseResponse(final String payload) {
        final JsonObject jsonObject = JsonParser.parseString(payload).getAsJsonObject();
        if (jsonObject.get("count").getAsLong() == 0) {
            return Collections.emptyList();
        }

        final List<String> fields = StreamSupport.stream(jsonObject.get("fields").getAsJsonArray().spliterator(), false)
                .map(JsonElement::getAsString)
                .collect(Collectors.toList());
        final JsonArray dataArray = jsonObject.get("data").getAsJsonArray();

        return StreamSupport.stream(dataArray.spliterator(), false)
                .map(JsonElement::getAsJsonArray)
                .map(jsonElements -> {
                    final Map<String, String> rawData = new HashMap<>();
                    for (int i = 0; i < fields.size(); i++) {
                        rawData.put(fields.get(i), jsonElements.get(i).getAsString());
                    }
                    return rawData;
                })
                .collect(Collectors.toList());
    }

    public void shutdown() {
        this.executorService.shutdown();
    }

}
