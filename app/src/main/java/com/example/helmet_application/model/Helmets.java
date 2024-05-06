package com.example.helmet_application.model;

import com.google.gson.annotations.SerializedName;

public class Helmets {
    @SerializedName("helmet_name")
    private String helmetName;
    @SerializedName("price")
    private String helmet_price;

    @SerializedName("helmet_image")
    private String helmet_image;

    public Helmets(String helmetName, String helmet_price, String helmet_image) {
        this.helmetName = helmetName;
        this.helmet_price = helmet_price;
        this.helmet_image = helmet_image;
    }

    public String getHelmetName() {
        return helmetName;
    }

    public void setHelmetName(String helmetName) {
        this.helmetName = helmetName;
    }

    public String getHelmet_price() {
        return helmet_price;
    }

    public void setHelmet_price(String helmet_price) {
        this.helmet_price = helmet_price;
    }

    public String getHelmet_image() {
        return helmet_image;
    }

    public void setHelmet_image(String helmet_image) {
        this.helmet_image = helmet_image;
    }
}
