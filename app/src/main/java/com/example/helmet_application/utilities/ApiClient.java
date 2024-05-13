package com.example.helmet_application.utilities;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.helmet_application.MainActivity;
import com.example.helmet_application.model.ContactInfo;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.model.User;
import com.example.helmet_application.model.UserLogin;
import com.example.helmet_application.view.viewholder.Login_Activity;
import com.example.helmet_application.view.viewholder.Signup_Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://192.168.137.1/helmets/";
    private static Retrofit retrofit;

    // Create the Retrofit instance
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Create ApiService instance
    public static ApiService createApiService() {
        return retrofit.create(ApiService.class);
    }

    public static void signupUser(User helmetUser, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();


        // Call the registerUser method in ApiService and pass the user object
        apiService.signupUser(helmetUser).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Registration successful
                    Log.d("ApiClient", "Registration successful!");
                    Intent intent = new Intent(context, Login_Activity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show();
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Registration failed
                    Log.d("ApiClient", "Registration failed. Please try again later. " + response.code() + response.raw().request());
                    Toast.makeText(context, "Registration failed. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Registration failed due to network error or other issues
                Log.e("ApiClient", "Registration failed: " + t.getMessage());
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to register user. Error: " + t.getMessage();
                }
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void loginHelmetUser(String username, String password, Context context) {
        ApiService apiService = createApiService();

        UserLogin helmetUser = new UserLogin(username, password);
        apiService.loginHelmetUser(helmetUser).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.code());
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                    Toast.makeText(context, "User successfully logged in.", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User successfully logged in.");
                } else {
                    if (response.code() == 401) { // Unauthorized - Incorrect username or password
                        Intent intent = new Intent(context, Signup_Activity.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "The User is not registered! Please register first", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(context, Login_Activity.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "User cannot log in. Try again later, please.", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("ApiClient", "User cannot log in. Try again later, please. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Login failed due to network error or other issues
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to login user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                Log.e("ApiClient", "Login failed: " + errorMessage);
            }
        });
    }
    public void getHelmets(ApiCallback callback) {
        Call<List<Helmets>> call = createApiService().getHelmets();
        call.enqueue(new Callback<List<Helmets>>() {
            @Override
            public void onResponse(Call<List<Helmets>> call, Response<List<Helmets>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Helmets> helmets = new ArrayList<>(response.body());
                    callback.onAccomplished(helmets);
                } else {
                    callback.onFailure("Failed to get helmets. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Helmets>> call, Throwable t) {
                callback.onFailure("Failed to get helmets: " + t.getMessage());
            }
        });
    }

    public static void contactInfo(ContactInfo contact, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();


        // Call the registerUser method in ApiService and pass the user object
        apiService.contactInfo(contact).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Registration successful
                    Log.d("ApiClient", "Your message is Successfully registered");
                    Toast.makeText(context, "Your message is Successfully registered", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("ApiClient", "Failed to register message. Response code: " + response.code() + response.raw().request());
                    Toast.makeText(context, "Failed to register message.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Registration failed due to network error or other issues
                Log.e("ApiClient", "Registration failed: " + t.getMessage());
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to register user. Error: " + t.getMessage();
                }
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
