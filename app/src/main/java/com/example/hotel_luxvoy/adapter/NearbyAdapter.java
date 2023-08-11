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
import com.example.hotel_luxvoy.models.Nearby;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> {

    private List<Nearby> nearbyList;

    private Context context;

    public NearbyAdapter(List<Nearby> nearbyList, Context context) {
        this.nearbyList = nearbyList;
        this.context = context;
    }

    @NonNull
    @Override
    public NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nearby, parent, false);
        return new NearbyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder holder, int position) {
        Nearby nearby = nearbyList.get(position);
        holder.imgNearby.setImageResource(nearby.getImage());
        holder.tvNearby.setText(nearby.getName());
        holder.tvAddress.setText(nearby.getAddress());

    }

    @Override
    public int getItemCount() {
        return nearbyList.size();
    }

    public class NearbyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgNearby;

        TextView tvNearby, tvAddress;

        public NearbyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNearby = itemView.findViewById(R.id.imgNearby);
            tvNearby = itemView.findViewById(R.id.tvNearby);
            tvAddress = itemView.findViewById(R.id.tvAddress);

        }
    }
}
