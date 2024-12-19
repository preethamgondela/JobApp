package com.initialpages.signup.and.login.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class LoginRequest {
	private String email;
    private String password;
    
    @Enumerated(EnumType.STRING) // Store enum as string in the database
    private Role role;

    // Getters and setters

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
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
