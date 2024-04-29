package com.example.helmet_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.helmet_application.view.About_Us_Fragment;
import com.example.helmet_application.view.ContactFragment;
import com.example.helmet_application.view.HomeFragment;
import com.example.helmet_application.view.ProductFragment;
import com.example.helmet_application.view.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    //Declaring necessary fragments for navigation
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ProductFragment productFragment = new ProductFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    About_Us_Fragment aboutUsFragment = new About_Us_Fragment();
    ContactFragment contactFragment =new ContactFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize BottomNavigationView and set up the listener
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);

        // Set the default selected item in the BottomNavigationView to "home"
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle item selection in the BottomNavigationView
        if (item.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.helmet){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, productFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.aboutUS){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutUsFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.contacts){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        }else {
            return false;
        }
    }
}