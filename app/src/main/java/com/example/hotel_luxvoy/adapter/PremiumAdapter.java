package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Premium;

import java.util.List;

public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.PremiumViewHolder> {

    private List<Premium> premiumList;

    private Context context;

    public PremiumAdapter(List<Premium> premiumList, Context context) {
        this.premiumList = premiumList;
        this.context = context;
    }

    @NonNull
    @Override
    public PremiumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_premium, parent, false);
        return new PremiumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumViewHolder holder, int position) {

        Premium premium = premiumList.get(position);
        holder.imgPremium.setImageResource(premium.getImage());
        holder.tvPremium.setText(premium.getDescription());

    }

    @Override
    public int getItemCount() {
        return premiumList.size();
    }

    public class PremiumViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPremium;
        private TextView tvPremium;

        public PremiumViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPremium = itemView.findViewById(R.id.imgPremium);
            tvPremium = itemView.findViewById(R.id.tvPremium);
        }
    }
}
