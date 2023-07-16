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

        hotelList.add(new Hotel(1, R.drawable.hotel_1, "Luxvoy Hotel and Tower Sai Gon", "Thủ Thiêm, Quận 2, Hồ Chí Minh", "Khá ổn: 8/10"));
        hotelList.add(new Hotel(2, R.drawable.hotel_2, "Luxvoy Hotel and Tower Hà Nội", "Cầu Giấy, Hà Nội", "Khá ổn: 8/10"));
        hotelList.add(new Hotel(3, R.drawable.hotel_3, "Luxvoy Hotel and Tower Đà Nẵng", "Hải Châu, Đà Nẵng", "Khá ổn: 8/10"));

        HotelAdapter hotelAdapter = new HotelAdapter(hotelList, this);
        recyclerView.setAdapter(hotelAdapter);


    }
}