package com.example.helmet_application.view.viewholder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helmet_application.R;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.utilities.ApiCallback;
import com.example.helmet_application.utilities.ApiClient;
import com.example.helmet_application.view.adapter.PostAdapter;

import java.util.ArrayList;


public class ProductFragment extends Fragment{
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private ArrayList<Helmets> helmets = new ArrayList<>();

    public ProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_helmet_recycler, container, false);

        recyclerView = view.findViewById(R.id.rvHelmetsCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        return view;
    }
}