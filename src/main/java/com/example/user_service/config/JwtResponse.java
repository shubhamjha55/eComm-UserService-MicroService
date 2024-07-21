package com.example.user_service.config;

public class JwtResponse {
    private int status;
    private String message;
    private String token;

    // Constructor for successful response
    public JwtResponse(int status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    // Constructor for unsuccessful response
    public JwtResponse(int status, String message) {
        this(status, message, null);
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
