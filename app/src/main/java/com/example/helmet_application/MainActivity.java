package com.example.helmet_application;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.utilities.ApiCallback;
import com.example.helmet_application.utilities.ApiClient;
import com.example.helmet_application.view.adapter.PostAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PostAdapter adapter;
    private ArrayList<Helmets> helmets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helmet_recycler);

        RecyclerView recyclerView = findViewById(R.id.rvHelmetsCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(helmets);
        recyclerView.setAdapter(adapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getHelmets(new ApiCallback() {
            @Override
            public void onSuccess(ArrayList<Helmets> productList) {
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
