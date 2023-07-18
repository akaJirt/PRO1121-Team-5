package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.ConfirmAndPayActivity;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.imageModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomAdaterViewHolder> {


    private ArrayList<Room> roomList;

    private Context context;


    public RoomAdapter(ArrayList<Room> roomList, Context context) {
        this.roomList = roomList;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomAdaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_room, null);
        return new RoomAdaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdaterViewHolder holder, int position) {

        Room room = roomList.get(position);
        holder.tvTypeRoom.setText(room.getType());
        holder.tvRoomPrice.setText(room.getPrice());
        Log.d("TAG", "onBindViewHolder: "+room.getRoomId());
        ArrayList<imageModel> images = room.getImages();
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            slideModels.add(new SlideModel(images.get(i).getLinkImg(), ScaleTypes.FIT));
        }



        holder.imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        holder.imgSelectRoom.setOnClickListener(v -> {
            Intent intent = new Intent(context, ConfirmAndPayActivity.class);
            intent.putExtra("room", room);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class RoomAdaterViewHolder extends RecyclerView.ViewHolder {
        ImageSlider imageSlider;

        ImageView imgSelectRoom;

        TextView tvTypeRoom, tvRoomPrice;

        public RoomAdaterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageSlider = itemView.findViewById(R.id.image_slider);
            imgSelectRoom = itemView.findViewById(R.id.imgSelectRoom);
            tvTypeRoom = itemView.findViewById(R.id.tvTypeRoom);
            tvRoomPrice = itemView.findViewById(R.id.tvRoomPrice);
        }
    }
}
