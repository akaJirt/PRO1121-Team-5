package com.example.hotel_luxvoy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;

public class BookDatesActivity extends AppCompatActivity {
    ImageView ivBack;
    TextView tvCheckIn, tvCheckOut;
    CalendarView cvCheckIn, cvCheckOut;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_booking_dates);
        ivBack = findViewById(R.id.ivBack);
        tvCheckIn = findViewById(R.id.tvCheckInDate);
        tvCheckOut = findViewById(R.id.tvCheckOutDate);
        cvCheckIn = findViewById(R.id.calendarCheckIn);
        cvCheckOut = findViewById(R.id.calendarCheckOut);

        ivBack.setOnClickListener(v -> {
            Intent intent = new Intent(BookDatesActivity.this, BookLocationActivity.class);
            startActivity(intent);
        });

        cvCheckIn.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            tvCheckIn.setText(date);
        });

        cvCheckOut.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String date = dayOfMonth + "/" + (month + 1) + "/" + year;
            tvCheckOut.setText(date);
        });


        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(v -> {
            Intent intent = new Intent(BookDatesActivity.this, HotelActivity.class);
            startActivity(intent);
        });

    }
}