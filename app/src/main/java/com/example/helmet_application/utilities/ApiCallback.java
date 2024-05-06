package com.example.helmet_application.utilities;

import com.example.helmet_application.model.Helmets;

import java.util.ArrayList;

public interface ApiCallback {
    void onSuccess(ArrayList<Helmets> productList);
    void onFailure(String message);
}
