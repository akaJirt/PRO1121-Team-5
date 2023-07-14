package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.MoreAdapter;
import com.example.hotel_luxvoy.adapter.ViewedAdapter;
import com.example.hotel_luxvoy.models.More;
import com.example.hotel_luxvoy.models.Viewed;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    TextView textView;

    ImageView imgBookNow;

    RecyclerView recyclerViewViewed, recyclerViewMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.tvBooking);
        String fullText = "It's time to switch off";
        String targetText = "switch off";
        int startIndex = fullText.indexOf(targetText);
        int endIndex = startIndex + targetText.length();

        SpannableString spannableString = new SpannableString(fullText);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#FFA500")); // Màu cam
        spannableString.setSpan(colorSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);

        imgBookNow = findViewById(R.id.imgBookNow);
        imgBookNow.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, BookCheck.class);
            startActivity(intent);
        });

        recyclerViewViewed = findViewById(R.id.rvViewed);
        recyclerViewViewed.setHasFixedSize(true);
        recyclerViewViewed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Viewed> viewedList = new ArrayList<>();
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Phu Quoc Beach, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Ha Long Bay, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Da Nang Beach, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Nha Trang Beach, Luxvoy Collection"));

        ViewedAdapter viewedAdapter = new ViewedAdapter(viewedList, this);
        recyclerViewViewed.setAdapter(viewedAdapter);

        recyclerViewMore = findViewById(R.id.rvMore);
        recyclerViewMore.setHasFixedSize(true);
        recyclerViewMore.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<More> moreList = new ArrayList<>();
        moreList.add(new More(R.drawable.img_more, "Resort relaxation await"));
        moreList.add(new More(R.drawable.img_more, "A rewarded stay at Renaissance Saigon"));
        moreList.add(new More(R.drawable.img_more, "A rewarded stay at Renaissance Saigon"));
        moreList.add(new More(R.drawable.img_more, "A rewarded stay at Renaissance Saigon"));
        MoreAdapter moreAdapter = new MoreAdapter(moreList, this);
        recyclerViewMore.setAdapter(moreAdapter);

    }
}