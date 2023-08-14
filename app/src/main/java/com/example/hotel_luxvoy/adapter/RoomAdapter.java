package com.example.hotel_luxvoy.adapter;

import static android.content.Intent.getIntent;

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
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.imageModel;
import com.example.hotel_luxvoy.models.imageModel1;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomAdaterViewHolder> {


    private ArrayList<Room> roomList;

    private Context context;

    private Hotel hotel;
    private Intent intent1;


    public RoomAdapter(ArrayList<Room> roomList, Context context, Hotel hotel, Intent intent) {
        this.roomList = roomList;
        this.context = context;
        this.hotel = hotel;
        this.intent1 = intent;
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
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        int price = Integer.parseInt(room.getPrice());
        holder.tvRoomPrice.setText(numberFormat.format(price) + " VNĐ/ Night");
        Log.d("TAG", "onBindViewHolder: " + room.get_id());
        ArrayList<String> images = room.getRoomImages();
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            slideModels.add(new SlideModel(images.get(i), ScaleTypes.FIT));
        }


        holder.imageSlider.setImageList(slideModels, ScaleTypes.FIT);
        holder.imgSelectRoom.setOnClickListener(v -> {
            Intent intent = new Intent(context, ConfirmAndPayActivity.class);
            intent.putExtra("room", room);
            intent.putExtra("hotel", hotel);
            intent.putExtra("checkInDate", intent1.getStringExtra("checkInDate"));
            intent.putExtra("checkOutDate", intent1.getStringExtra("checkOutDate"));
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
