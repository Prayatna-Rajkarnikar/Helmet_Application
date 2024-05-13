package com.example.helmet_application;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helmet_application.view.viewholder.About_Us_Fragment;
import com.example.helmet_application.view.viewholder.ContactFragment;
import com.example.helmet_application.view.viewholder.HomeFragment;
import com.example.helmet_application.view.viewholder.ProductFragment;
import com.example.helmet_application.view.viewholder.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{
    BottomNavigationView bottomNavView;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ProductFragment productFragment = new ProductFragment();
    About_Us_Fragment aboutUsFragment = new About_Us_Fragment();
    ContactFragment contactFragment = new ContactFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setOnItemSelectedListener(this);
        bottomNavView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
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
        }else if(item.getItemId() == R.id.contacts) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        } else {
            return false;
        }
    }
}
