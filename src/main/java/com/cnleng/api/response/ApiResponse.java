package com.cnleng.api.response;

public abstract class ApiResponse {

    protected String message;
    protected Exception error;

    public ApiResponse() {
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, Exception error) {
        this(message);
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }
}
