package com.example.helmet_application.view.viewholder;

import android.os.Bundle;

import com.example.helmet_application.R;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.utilities.ApiCallback;
import com.example.helmet_application.utilities.ApiClient;
import com.example.helmet_application.view.adapter.PostAdapt;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelmetRecyclerActivity extends AppCompatActivity {

    private PostAdapt adapter;
    private ArrayList<Helmets> helmets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helmet_recycler);

        RecyclerView recyclerView = findViewById(R.id.rvHelmetsCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapt(helmets);
        recyclerView.setAdapter(adapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getHelmets(new ApiCallback() {
            @Override
            public void onAccomplished(ArrayList<Helmets> productList) {
                helmets.clear();
                helmets.addAll(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                // Handle failure
            }
        });
    }
}