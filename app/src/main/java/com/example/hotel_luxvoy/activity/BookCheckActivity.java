package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;

public class BookCheckActivity extends AppCompatActivity {
    ImageView imgBack, imgBookNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_book_check);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(v -> {
            finish();
        });

        imgBookNow = findViewById(R.id.imgBookNow);
        imgBookNow.setOnClickListener(v -> {
            Intent intent = new Intent(BookCheckActivity.this, BookLocationActivity.class);
            startActivity(intent);
        });
    }
}