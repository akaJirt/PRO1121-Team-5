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
    private TextView tvHotelName;

    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_room);

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            finish();
        });

        tvHotelName = findViewById(R.id.tvHotelName);
        tvHotelName.setText(getIntent().getStringExtra("hotelName"));

        recyclerView = findViewById(R.id.rvRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomList = (ArrayList<Room>)getIntent().getSerializableExtra("roomList");


        RoomAdapter roomAdapter = new RoomAdapter(roomList, this);
        recyclerView.setAdapter(roomAdapter);
    }



}
