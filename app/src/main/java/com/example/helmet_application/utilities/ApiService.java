package com.example.helmet_application.utilities;

import com.example.helmet_application.model.User;
import com.example.helmet_application.model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register.php")
    Call<Object> registerUser(@Body User user);

    @POST("login.php")
    Call<Object> loginUser(@Body UserLogin password);
}
