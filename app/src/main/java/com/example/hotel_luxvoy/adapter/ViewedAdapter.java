package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Viewed;

import java.util.List;

public class ViewedAdapter extends RecyclerView.Adapter<ViewedAdapter.ViewedViewHolder> {
    private List<Viewed> viewedList;

    private Context context;

    public ViewedAdapter(List<Viewed> viewedList, Context context) {
        this.viewedList = viewedList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_viewed, null);
        return new ViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewedViewHolder holder, int position) {
        Viewed viewed = viewedList.get(position);
        holder.tvViewed.setText(viewed.getDescription());
        holder.imgViewed.setImageResource(viewed.getImage());
    }

    @Override
    public int getItemCount() {
        return viewedList.size();
    }

    public class ViewedViewHolder extends RecyclerView.ViewHolder {
        TextView tvViewed;

        ImageView imgViewed;

        public ViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvViewed = itemView.findViewById(R.id.tvViewed);
            imgViewed = itemView.findViewById(R.id.imgViewed);
        }
    }
}

