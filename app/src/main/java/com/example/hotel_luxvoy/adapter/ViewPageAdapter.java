package com.example.hotel_luxvoy.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hotel_luxvoy.fragment.FragmentCancelled;
import com.example.hotel_luxvoy.fragment.FragmentCurrent;
import com.example.hotel_luxvoy.fragment.FragmentPast;

public class ViewPageAdapter extends FragmentStatePagerAdapter {


    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new FragmentPast();
            case 2:
                return new FragmentCancelled();
            default:
                return new FragmentCurrent();
        }

    }


    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case 1:
                return "Past";
            case 2:
                return "Cancelled";
            default:
                return "Current";

        }
    }
}
