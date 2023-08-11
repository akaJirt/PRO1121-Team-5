package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.ViewPageAdapterAccount;
import com.google.android.material.tabs.TabLayout;


public class AccountFragment extends Fragment {

    ViewPageAdapterAccount aCAdapter;

    FrameLayout aframeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tablayout1);
        ViewPager viewPagera = view.findViewById(R.id.view_pager1);
        FragmentManager fragmentManager = getChildFragmentManager();
        aCAdapter = new ViewPageAdapterAccount(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagera.setAdapter(aCAdapter);
        tabLayout.setupWithViewPager(viewPagera);
        return view;
    }
}