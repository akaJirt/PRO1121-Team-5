package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Explore;

import java.util.List;

public class ExploreAdaper extends RecyclerView.Adapter<ExploreAdaper.ExploreViewHolder> {

    private List<Explore> exploreList;

    private Context context;

    public ExploreAdaper(List<Explore> exploreList, Context context) {
        this.exploreList = exploreList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExploreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_explore, null);
        return new ExploreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHolder holder, int position) {
        Explore explore = exploreList.get(position);
        holder.imgExplore.setImageResource(explore.getImage());
        holder.tvExplore.setText(explore.getDescription());
    }

    @Override
    public int getItemCount() {
        return exploreList.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        ImageView imgExplore;
        TextView tvExplore;

        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);
            imgExplore = itemView.findViewById(R.id.imgExplore);
            tvExplore = itemView.findViewById(R.id.tvExplore);
        }
    }
}
