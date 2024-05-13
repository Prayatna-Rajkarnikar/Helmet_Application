package com.example.helmet_application.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helmet_application.R;

public class HelmetDetails extends RecyclerView.ViewHolder {
    public TextView tvHelmetName;
    public TextView tvPrice;
    public ImageView imgHelmets;

    public HelmetDetails(@NonNull View itemView) {
        super(itemView);

        tvHelmetName = itemView.findViewById(R.id.tvHelmetName);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        imgHelmets = itemView.findViewById(R.id.imgHelmets );


    }
}
