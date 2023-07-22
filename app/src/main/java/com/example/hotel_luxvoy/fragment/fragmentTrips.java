package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class fragmentTrips extends Fragment {
    ViewPageAdapter adapter;
//    private TabLayout mTabLayout;
//    private ViewPager mviewPager;
FrameLayout  mframeLayout;

    public fragmentTrips(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View mview = inflater.inflate(R.layout.fragment_trips, container,false);
        TabLayout tabLayout = mview.findViewById(R.id.tablayout);
        ViewPager viewPager = mview.findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getChildFragmentManager();
       // adapter = new ViewPageAdapter(fragmentManager);
        adapter = new ViewPageAdapter(getChildFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
            return mview; }

}
