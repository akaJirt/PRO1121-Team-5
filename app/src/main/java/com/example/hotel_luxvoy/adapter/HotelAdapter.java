package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.RoomActivity;
import com.example.hotel_luxvoy.models.Hotel;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelAdapterViewHolder> {

    private Context context;

    private List<Hotel> hotelList;


    public HotelAdapter(List<Hotel> hotelList, Context context) {
        this.context = context;
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public HotelAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false);
        return new HotelAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapterViewHolder holder, int position) {
        Hotel hotel = hotelList.get(position);
        holder.imgHotel.setImageResource(hotel.getImage());
        holder.tvHotelName.setText(hotel.getHotelName());
        holder.tvHotelRating.setText(hotel.getRating());
        holder.tvHotelPrice.setText(hotel.getPrice());
        holder.imgSelectRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RoomActivity.class);
                intent.putExtra("roomList", (Serializable) hotel.getRooms());
                intent.putExtra("hotelName", hotel.getHotelName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class HotelAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgHotel, imgSelectRoom;

        TextView tvHotelName, tvHotelRating, tvHotelPrice;


        public HotelAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.imgHotel);
            imgSelectRoom = itemView.findViewById(R.id.imgSelectRoom);
            tvHotelName = itemView.findViewById(R.id.tvHotelName);
            tvHotelRating = itemView.findViewById(R.id.tvRating);
            tvHotelPrice = itemView.findViewById(R.id.tvPrice);

        }


        @Override
        public void onClick(View v) {

        }
    }
}
