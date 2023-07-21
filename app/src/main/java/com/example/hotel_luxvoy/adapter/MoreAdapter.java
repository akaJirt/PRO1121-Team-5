package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.More;

import java.util.List;

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MoreViewHolder> {

    private Context context;
    private List<More> moreList;

    public MoreAdapter(List<More> moreList, Context context) {
        this.moreList = moreList;
        this.context = context;
    }

    @NonNull
    @Override
    public MoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_more, null);
        return new MoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreViewHolder holder, int position) {
        More more = moreList.get(position);
        holder.tvtvMore.setText(more.getDescription());
        holder.imgMore.setImageResource(more.getImage());
    }

    @Override
    public int getItemCount() {
        return moreList.size();
    }

    public class MoreViewHolder extends RecyclerView.ViewHolder {
        TextView tvtvMore;

        ImageView imgMore;

        public MoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtvMore = itemView.findViewById(R.id.tvMore);
            imgMore = itemView.findViewById(R.id.imgMore);
        }
    }
}
