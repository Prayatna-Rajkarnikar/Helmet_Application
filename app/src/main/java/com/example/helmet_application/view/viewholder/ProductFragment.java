package com.example.helmet_application.view.viewholder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helmet_application.R;


public class ProductFragment extends RecyclerView.ViewHolder {
    public TextView tvHelmetName;
    public TextView tvPrice;
    public ImageView imgHelmets;

    public ProductFragment(@NonNull View itemView) {
        super(itemView);

        tvHelmetName = itemView.findViewById(R.id.tvHelmetName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        imgHelmets = itemView.findViewById(R.id.imgHelmets );


    }

}