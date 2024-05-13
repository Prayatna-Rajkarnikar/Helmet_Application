package com.example.helmet_application.view.viewholder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helmet_application.R;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.utilities.ApiCallback;
import com.example.helmet_application.utilities.ApiClient;
import com.example.helmet_application.view.adapter.PostAdapt;

import java.util.ArrayList;


public class ProductFragment extends Fragment{
    private RecyclerView helmetRecycleView;
    private PostAdapt adapt;
    private ArrayList<Helmets> helmets = new ArrayList<>();

    public ProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_helmet_recycler, container, false);

        helmetRecycleView = view.findViewById(R.id.rvHelmetsCards);
        helmetRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapt = new PostAdapt(helmets);
        helmetRecycleView.setAdapter(adapt);

        ApiClient apiClient = new ApiClient();
        apiClient.getHelmets(new ApiCallback() {
            @Override
            public void onAccomplished(ArrayList<Helmets> helmetList) {
                helmets.clear();
                helmets.addAll(helmetList);
                adapt.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                // Handle failure
            }
        });
        return view;
    }
}