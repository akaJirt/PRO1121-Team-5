package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.HotelAdapter;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HotelAdapter hotelAdapter;
    private List<Hotel> hotelList;
    private List<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_hotel);

        Intent intent = getIntent();
        String hotelName = intent.getStringExtra("nameDestination");
        TextView tvHotelName = findViewById(R.id.tvHotelName);
        tvHotelName.setText(hotelName);

        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            finish();
        });

        recyclerView = findViewById(R.id.rvHotel);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomList = new ArrayList<>();

        int[] roomImages = {R.drawable.room_1, R.drawable.room_2, R.drawable.room_3, R.drawable.room_4};
        int[] roomImages2 = {R.drawable.room_2, R.drawable.room_3, R.drawable.room_1};
        int[] roomImages3 = {R.drawable.room_3, R.drawable.room_1, R.drawable.room_2};
        int[] roomImages4 = {R.drawable.room_4, R.drawable.room_2, R.drawable.room_3};



        roomList.add(new Room(1, roomImages, "1 King bed, guest room, Non-smoking", "120 USD", "Trống", "2"));
        roomList.add(new Room(2, roomImages2, "2 Twin/single bed, guest room, Non-smoking", "140 USD", "Trống", "2"));
        roomList.add(new Room(3, roomImages3, "Twin King bed, guest room, Non-smoking", "150 USD", "Trống", "2"));
        roomList.add(new Room(4, roomImages4, "1 King bed, guest room, Non-smoking", "120 USD", "Trống", "2"));

        hotelList = new ArrayList<>();
        hotelList.add(new Hotel(1, R.drawable.hotel_1, "Luxvoy Luxury Hotel South Sai Gon", "4.5", "120 USD / Night", roomList));


        hotelAdapter = new HotelAdapter(hotelList, this);
        recyclerView.setAdapter(hotelAdapter);
    }
}
