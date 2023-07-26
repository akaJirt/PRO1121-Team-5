package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Explore;
import com.example.hotel_luxvoy.models.Luxury;

import java.util.List;

public class LuxuryAdapter extends RecyclerView.Adapter<LuxuryAdapter.LuxuryViewHolder>{

    private List<Luxury> luxuryList;

    private Context context;


    public LuxuryAdapter(List<Luxury> luxuryList, Context context) {
        this.luxuryList = luxuryList;
        this.context = context;
    }
    @NonNull
    @Override
    public LuxuryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_luxury, parent, false);
        return new LuxuryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LuxuryViewHolder holder, int position) {
        Luxury luxury = luxuryList.get(position);
        holder.imgLuxury.setImageResource(luxury.getImage());
        holder.tvLuxury.setText(luxury.getDescription());

    }

    @Override
    public int getItemCount() {
        return luxuryList.size();
    }

    public class LuxuryViewHolder extends RecyclerView.ViewHolder {

        TextView tvLuxury;

        ImageView imgLuxury;
        public LuxuryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLuxury = itemView.findViewById(R.id.tvLuxury);
            imgLuxury = itemView.findViewById(R.id.imgLuxury);
        }
    }
}
