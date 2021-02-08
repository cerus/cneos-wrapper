package de.cerus.cneoswrapper.http;

public class ApiResponse<T> {

    private final T data;
    private final Throwable error;

    public ApiResponse(final T data, final Throwable error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return this.data;
    }

    public Throwable getError() {
        return this.error;
    }

}
