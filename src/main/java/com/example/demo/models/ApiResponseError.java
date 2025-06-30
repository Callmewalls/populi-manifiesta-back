package com.example.demo.models;

public class ApiResponseError {
    private int statusCode; // Código HTTP de la respuesta
    private String message; // Mensaje descriptivo del error
    private String error;   // Tipo de error (por ejemplo, "Bad Request", "Unauthorized", etc.)
    private String path;    // La URL o el endpoint donde ocurrió el error

    public ApiResponseError(){
        
    }

    public ApiResponseError(int statusCode, String message, String error, String path) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
        this.path = path;
    }

    // Getters y setters

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

