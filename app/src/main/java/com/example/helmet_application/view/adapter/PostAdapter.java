package com.example.helmet_application.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helmet_application.R;
import com.example.helmet_application.model.Helmets;
import com.example.helmet_application.view.viewholder.ProductFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<ProductFragment> {
    private ArrayList<Helmets> helmets;

    public PostAdapter(ArrayList<Helmets> products) {
        this.helmets = products;
    }

    @NonNull
    @Override
    public ProductFragment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_product, parent, false);
        return new ProductFragment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFragment holder, int position) {
        Helmets product = helmets.get(position);
        holder.tvHelmetName.setText(product.getHelmetName());
        holder.tvPrice.setText(product.getHelmet_price());

        int placeholderResource = R.drawable.
                ic_launcher_background;
        int errorResource = R.drawable.ic_contact_foreground;

        Picasso.get()
                .load(product.getHelmet_image())
                .placeholder(placeholderResource)
                .error(errorResource)
                .into(holder.imgHelmets);
    }

    @Override
    public int getItemCount() {
        return helmets.size();
    }

}
