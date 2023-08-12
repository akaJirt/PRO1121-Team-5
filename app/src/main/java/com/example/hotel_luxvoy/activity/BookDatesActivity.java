package com.example.hotel_luxvoy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;

public class BookDatesActivity extends AppCompatActivity {
    ImageView ivBack;
    TextView tvCheckIn, tvCheckOut;
    CalendarView cvCheckIn, cvCheckOut;
    Button btnContinue;
    String selectedLocation, checkInDate, checkOutDate;

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
        Intent intent1 = getIntent();
        selectedLocation = intent1.getStringExtra("selectedLocation");
        UserAfterCheckLG userAfterCheckLG = (UserAfterCheckLG) intent1.getSerializableExtra("user");
        Log.d("Bookdate>>>>>>>>", "onCreate: " + selectedLocation);
        checkInDate = tvCheckIn.getText().toString();
        checkOutDate = tvCheckOut.getText().toString();
        ivBack.setOnClickListener(v -> {
            finish();
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


            if (selectedLocation != null) {
                switch (selectedLocation) {
                    case "default":
                        intent.putExtra("selectedLocation", "default");
                        break;
                    case "Ha Noi City":
                        intent.putExtra("selectedLocation", "Hà Nội");
                        break;
                    case "Ho Chi Minh City":
                        intent.putExtra("selectedLocation", "Hồ Chí Minh");
                        break;
                }

            } else {
                intent.putExtra("selectedLocation", "default");
            }

            //dd/mm/yyyy to yyyy-mm-dd
            String[] arrCheckInDate = tvCheckIn.getText().toString().split("/");
            String checkInDate = arrCheckInDate[2] + "/" + arrCheckInDate[1] + "/" + arrCheckInDate[0];
            intent.putExtra("checkInDate", checkInDate);

            String[] arrCheckOutDate = tvCheckOut.getText().toString().split("/");
            String checkOutDate = arrCheckOutDate[2] + "/" + arrCheckOutDate[1] + "/" + arrCheckOutDate[0];
            intent.putExtra("checkOutDate", checkOutDate);

            intent.putExtra("checkInDate", tvCheckIn.getText().toString());
            intent.putExtra("checkOutDate", tvCheckOut.getText().toString());
            intent.putExtra("user", userAfterCheckLG);
            startActivity(intent);
        });

    }
}