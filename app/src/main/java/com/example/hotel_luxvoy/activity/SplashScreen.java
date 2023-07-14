package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.hotel_luxvoy.R;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView = findViewById(R.id.splash_image);

        RequestOptions requestOptions; // Không lưu cache của GIF
        requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA);

        Glide.with(this)
                .load(R.drawable.logo) // Tên của tệp GIF trong thư mục "res/drawable"
                .apply(requestOptions)
                .into(imageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(SplashScreen.this, OnboardingSlider.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }
}