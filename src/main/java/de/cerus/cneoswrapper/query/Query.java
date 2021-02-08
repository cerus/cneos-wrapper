package de.cerus.cneoswrapper.query;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Query {

    private final Map<String, String> paramMap = new HashMap<>();

    public void putParam(final String name, final String value) {
        this.paramMap.put(name, value);
    }

    public String buildQueryString() {
        return this.buildQueryString(true);
    }

    public String buildQueryString(final boolean encoded) {
        final StringBuilder stringBuilder = new StringBuilder("?");
        this.paramMap.forEach((name, val) ->
                stringBuilder.append(encoded ? URLEncoder.encode(name, StandardCharsets.UTF_8) : name).append("=")
                        .append(encoded ? URLEncoder.encode(val, StandardCharsets.UTF_8) : val).append("&"));
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

}
