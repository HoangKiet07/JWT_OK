package com.example.security_part_2.dto.request;

public class SignInForm {
    private String username;
    private String password;

    public SignInForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignInForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
