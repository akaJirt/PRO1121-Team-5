package com.example.hotel_luxvoy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hotel_luxvoy.fragment.AccountFragment;
import com.example.hotel_luxvoy.fragment.BookingFragment;
import com.example.hotel_luxvoy.fragment.HomeFragment;
import com.example.hotel_luxvoy.fragment.TripsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        FullScreenHelper.setFullScreen(this);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.nav_booking) {
                replaceFragment(new BookingFragment());
            } else if (itemId == R.id.nav_trips) {
                replaceFragment(new TripsFragment());
            } else if (itemId == R.id.nav_account) {
                replaceFragment(new AccountFragment());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }

//        startActivity(new Intent(BookActivity.this, BookLocation.class));
    }