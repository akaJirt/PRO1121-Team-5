package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotel_luxvoy.R;
import com.google.android.material.tabs.TabLayout;

public class fragmentTrips extends Fragment {
    private TabLayout mTabLayout;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_trips, container,false);
        FrameLayout frameLayout = view.findViewById(R.id.frameLayout1);
        TextView txtCurrent = view.findViewById(R.id.txtCurrent);



        return view;
    }
}
