package com.example.hotel_luxvoy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.hotel_luxvoy.fragment.FragmentAccount;
import com.example.hotel_luxvoy.fragment.fragmentTrips;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        frameLayout2 = findViewById(R.id.frameLayout2);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        replaceFragment(new fragmentTrips());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.nav_trips){
                replaceFragment(new fragmentTrips());
            }
            if(itemId == R.id.nav_account){
                replaceFragment(new FragmentAccount());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment ) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout2.getId(), fragment);
        fragmentTransaction.commit();
    }
}