package com.example.hotel_luxvoy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;

public class BookLocationActivity extends AppCompatActivity {

    ImageView ivBack;

    AutoCompleteTextView etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_booking_location);
        ivBack = findViewById(R.id.ivBack);
        etLocation = findViewById(R.id.edLocation);
        ivBack.setOnClickListener(v -> {
            Intent intent = new Intent(BookLocationActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        String[] suggestions = {"Ho Chi Minh City", "Ha Noi City"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, suggestions);
        etLocation.setAdapter(adapter);
        etLocation.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            Intent intent = new Intent(BookLocationActivity.this, BookDatesActivity.class);
            // Truyền dữ liệu từ item đã chọn qua màn hình mới
            intent.putExtra("selectedLocation", selectedItem);
            startActivity(intent);
        });
    }
}