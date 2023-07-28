package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Gallery;
import com.example.hotel_luxvoy.models.ListHA;

import java.util.List;

public class RCV2Adapter extends RecyclerView.Adapter<RCV2Adapter.RCV2ViewHolder> {
    private Context context;
    private List<Gallery> mGallery;
    public RCV2Adapter(List<Gallery> mGallery, Context context) {
        this.mGallery = mGallery;
        this.context = context;
    }
    @NonNull
    @Override
    public RCV2Adapter.RCV2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_item2, null);

        return new RCV2Adapter.RCV2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCV2Adapter.RCV2ViewHolder holder, int position) {
        Gallery gallery = mGallery.get(position);
        holder.imgRoom.setImageResource(gallery.getImage());
    }

    @Override
    public int getItemCount() {
        return mGallery.size();
    }

    public class RCV2ViewHolder extends RecyclerView.ViewHolder {


        ImageView imgRoom;

        public RCV2ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRoom = itemView.findViewById(R.id.imgRoom);
        }
    }
}
