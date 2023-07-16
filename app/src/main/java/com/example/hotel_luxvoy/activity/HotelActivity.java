package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.HotelAdapter;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        recyclerView = findViewById(R.id.rvHotel);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Hotel> hotelList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();

        roomList.add(new Room(1, "King Bed", "100 USD", "Trống", "2"));
        roomList.add(new Room(2, "Queen Bed", "100 USD", "Trống", "2"));
        roomList.add(new Room(3, "Double Bed", "100 USD", "Trống", "2"));

        hotelList.add(new Hotel(1, R.drawable.hotel_1, "Luxvoy Luxury Hotel South Sai Gon", "4.5", "120 USD / Night", roomList));
//


        HotelAdapter hotelAdapter = new HotelAdapter(hotelList, this);
        recyclerView.setAdapter(hotelAdapter);


    }
}