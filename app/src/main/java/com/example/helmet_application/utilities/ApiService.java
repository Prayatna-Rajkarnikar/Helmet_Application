package com.example.helmet_application.utilities;

import com.example.helmet_application.model.ContactInfo;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.model.User;
import com.example.helmet_application.model.UserLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register.php")
    Call<Object> signupUser(@Body User user);

    @POST("login.php")
    Call<Object> loginHelmetUser(@Body UserLogin password);

    @GET("helmets.php")
    Call<List<Helmets>> getHelmets();

    @POST("contactPage.php")
    Call<Object> contactInfo(@Body ContactInfo contact);
}
