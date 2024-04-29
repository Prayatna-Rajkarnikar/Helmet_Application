package com.example.helmet_application.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_Name")
    private String user_Name;
    @SerializedName("user_FullName")
    private String user_FullName;

    @SerializedName("user_Email")
    private String user_Email;

    @SerializedName("password")
    private String password;

    public User(String user_Name, String user_FullName,  String user_Email, String password) {
        this.user_Name = user_Name;
        this.user_FullName = user_FullName;
        this.user_Email = user_Email;
        this.password = password;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }
    public String getUser_FullName() {
        return user_FullName;
    }

    public void setUser_FullName(String user_FullName) {
        this.user_FullName = user_FullName;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
