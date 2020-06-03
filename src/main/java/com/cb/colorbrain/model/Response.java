package com.cb.colorbrain.model;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;
    private int statusCode;

    public Response(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", succesCode=" + statusCode +
                '}';
    }
}
