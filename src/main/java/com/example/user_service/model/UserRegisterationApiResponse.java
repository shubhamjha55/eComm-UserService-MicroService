package com.example.user_service.model;

public class UserRegisterationApiResponse {
    private String message;

    public UserRegisterationApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
