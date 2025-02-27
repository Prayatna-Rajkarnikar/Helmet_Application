package com.example.helmet_application.model;

import com.google.gson.annotations.SerializedName;

public class UserLogin {
    @SerializedName("user_Name")
    private String username;

    @SerializedName("password")
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
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
