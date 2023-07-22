package com.example.hotel_luxvoy.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.activity.RoomActivity;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.imageModel;
import com.example.hotel_luxvoy.models.imageModel1;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        ArrayList<imageModel1> images = hotel.getImages();
        Log.d("TAG>>>>>>>>>>>>>>>>>>>>>>>", "onBindViewHolder: "+images.get(0).getLinkImg());
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            slideModels.add(new SlideModel(images.get(i).getLinkImg(), ScaleTypes.FIT));
        }


        holder.imgHotel.setImageList(slideModels, ScaleTypes.FIT);
        holder.tvHotelName.setText(hotel.getHotelName());
        holder.tvHotelRating.setText(hotel.getRating());
        holder.tvHotelPrice.setText(hotel.getPrice());
        Log.d("TAG", "onBindViewHolder: "+hotel.getRooms().size());
        holder.imgSelectRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RoomActivity.class);
                intent.putExtra("roomList", (Serializable) hotel.getRooms());
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("roomList", (Serializable) hotel.getRooms());
                Log.d("TAG", "onClick: "+hotel.getRooms().size());
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
        ImageSlider imgHotel;
        ImageView  imgSelectRoom;

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
