package com.initialpages.signup.and.login.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LoginRequest {

    private String email;  
    private String password;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
