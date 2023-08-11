package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.adapter.RoomAdapter;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoomActivity extends AppCompatActivity {

    private ArrayList<Room> roomList;
    private RecyclerView recyclerView;
    private TextView tvHotelName, tvRoomAvailable;

    private ImageView ivBack;
    private Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_room);
        intent1 = getIntent();
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            finish();
        });

        Hotel hotel = (Hotel)getIntent().getSerializableExtra("hotel");


        tvHotelName = findViewById(R.id.tvHotelName);
        tvRoomAvailable = findViewById(R.id.tvRoomAvailable);
        tvHotelName.setText(getIntent().getStringExtra("hotelName"));

        recyclerView = findViewById(R.id.rvRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomList = (ArrayList<Room>)getIntent().getSerializableExtra("roomList");
        tvRoomAvailable.setText(roomList.size() + " Room types avaiable");

        RoomAdapter roomAdapter = new RoomAdapter(roomList, this, hotel,intent1);
        recyclerView.setAdapter(roomAdapter);
    }



}


