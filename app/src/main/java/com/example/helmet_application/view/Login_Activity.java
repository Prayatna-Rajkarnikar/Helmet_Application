package com.example.helmet_application.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helmet_application.R;
import com.example.helmet_application.utilities.ApiClient;


public class Login_Activity extends AppCompatActivity {

    private EditText usernameEditTxt;
    private EditText passwordEditTxt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditTxt = findViewById(R.id.et_loginUsername);
        passwordEditTxt = findViewById(R.id.et_loginPassword);
        loginBtn = findViewById(R.id.btn_Login);

        loginBtn.setOnClickListener(v -> {
            String username = usernameEditTxt.getText().toString();
            String password = passwordEditTxt.getText().toString();

            Log.d("LoginPage", "Username: " + username);
            Log.d("LoginPage", "Password: " + password);

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login_Activity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else {
                // Call loginUser method with username, password, and context
                ApiClient.loginUser(username, password, Login_Activity.this);
            }
        });

    }
}