package com.example.demo.models;

// src/main/java/com/example/api/ApiResponse.java
public record BasicResponse<T>(
    String message,
    int status,
    T data
) {
    public static <T> BasicResponse<T> success(String message, T data) {
        return new BasicResponse<>(message, 200, data);
    }

    public static BasicResponse<Void> success(String message) {
        return new BasicResponse<>(message, 200, null);
    }

    public static BasicResponse<Void> error(String message, int status) {
        return new BasicResponse<>(message, status, null);
    }
}
