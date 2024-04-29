package com.example.helmet_application.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helmet_application.R;
import com.example.helmet_application.model.User;
import com.example.helmet_application.utilities.ApiClient;

public class Signup_Activity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameEditText = findViewById(R.id.et_signupUsername);
        fullNameEditText = findViewById(R.id.et_FullName);
        emailEditText = findViewById(R.id.et_signupEmail);
        passwordEditText = findViewById(R.id.et_signupPassword);
        registerButton = findViewById(R.id.btn_Signup);

        registerButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String fullName = fullNameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Inside registerButton.setOnClickListener
            Log.d("Signup_Activity", "Username: " + username);
            Log.d("Signup_Activity", "Full Name: " + fullName);
            Log.d("Signup_Activity", "Email: " + email);
            Log.d("Signup_Activity", "Password: " + password);

            if (username.isEmpty() ||fullName.isEmpty() ||  email.isEmpty() || password.isEmpty()) {
                Toast.makeText(Signup_Activity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                User user = new User( username, fullName, email,  password);
                System.out.println(user.getUser_FullName());
                registerUser(user);
            }
        });
    }

    private void registerUser(User user) {
        ApiClient.registerUser(user, this);
    }
}