package com.cnleng.api.response;

import java.io.Serializable;

public abstract class ApiResponse implements Serializable {

    protected String message;
    protected String error;

    public ApiResponse() {
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, String error) {
        this(message);
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
