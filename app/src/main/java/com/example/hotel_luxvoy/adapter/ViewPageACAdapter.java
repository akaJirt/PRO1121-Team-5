package com.example.hotel_luxvoy.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hotel_luxvoy.fragment.FragmentSetting;
import com.example.hotel_luxvoy.fragment.FragmentSupport;

public class ViewPageACAdapter extends FragmentStatePagerAdapter {

    public ViewPageACAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentSetting();
            case 1:
                return new FragmentSupport();
            default:
                return new FragmentSetting();
        }


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Settings";
            case 1:
                return "Support";

            default:
                return "Setting";

        }
    }
}
