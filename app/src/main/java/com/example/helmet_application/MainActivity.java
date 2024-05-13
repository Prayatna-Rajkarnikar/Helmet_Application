package com.example.helmet_application;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.utilities.ApiCallback;
import com.example.helmet_application.utilities.ApiClient;
import com.example.helmet_application.view.adapter.PostAdapter;
import com.example.helmet_application.view.viewholder.About_Us_Fragment;
import com.example.helmet_application.view.viewholder.ContactFragment;
import com.example.helmet_application.view.viewholder.HomeFragment;
import com.example.helmet_application.view.viewholder.ProductFragment;
import com.example.helmet_application.view.viewholder.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ProductFragment productFragment = new ProductFragment();
    About_Us_Fragment aboutUsFragment = new About_Us_Fragment();
    ContactFragment contactFragment = new ContactFragment();
    //private PostAdapter adapter;
    //private ArrayList<Helmets> helmets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home_screen);
        setContentView(R.layout.activity_main);
//        RecyclerView recyclerView = findViewById(R.id.rvPost);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new HomePostAdapter(products);
//        recyclerView.setAdapter(adapter);
//
//        ApiClient apiClient = new ApiClient();
//        apiClient.getProducts(new ApiCallback() {
//            @Override
//            public void onSuccess(ArrayList<Product> productList) {
//                products.clear();
//                products.addAll(productList);
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(String message) {
//                // Handle failure
//            }
//        });
        bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
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
