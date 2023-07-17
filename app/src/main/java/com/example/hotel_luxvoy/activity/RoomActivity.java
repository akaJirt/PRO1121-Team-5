package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.RoomAdapter;
import com.example.hotel_luxvoy.models.Room;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private List<Room> roomList;
    private RecyclerView recyclerView;
    private TextView tvHotelName, tvRoomAvailable;

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
        tvRoomAvailable = findViewById(R.id.tvRoomAvailable);
        tvHotelName.setText(getIntent().getStringExtra("hotelName"));

        recyclerView = findViewById(R.id.rvRoom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomList = (List<Room>) getIntent().getSerializableExtra("roomList");
        tvRoomAvailable.setText(roomList.size() + " Room types avaiable");

        RoomAdapter roomAdapter = new RoomAdapter(roomList, this);
        recyclerView.setAdapter(roomAdapter);
    }
}
