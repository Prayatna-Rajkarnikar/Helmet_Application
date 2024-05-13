package com.example.helmet_application.model;
import com.google.gson.annotations.SerializedName;
public class ContactInfo {

    @SerializedName("user_FullName")
    private String user_FullName;

    @SerializedName("user_Email")
    private String user_Email;

    @SerializedName("description")
    private String description;

    public ContactInfo(String user_FullName, String user_Email, String description) {
        this.user_FullName = user_FullName;
        this.user_Email = user_Email;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
