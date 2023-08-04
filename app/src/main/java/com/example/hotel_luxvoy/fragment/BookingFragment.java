package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.models.Nearby;

import java.util.ArrayList;
import java.util.List;


public class BookingFragment extends Fragment {
    RecyclerView recyclerViewNearby, recyclerViewRecently, recyclerViewFeatured, recyclerViewLux, recyclerViewPre;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_booking, container, false);

        recyclerViewNearby = recyclerViewNearby.findViewById(R.id.rvViewed);
        recyclerViewNearby.setHasFixedSize(true);
        recyclerViewNearby.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        // ... Tiếp tục khởi tạo và cấu hình recyclerViewNearby
        List<Nearby> nearbyList = new ArrayList<>();
        nearbyList.add(new Nearby(R.drawable.saigon1, "Luxvoy Luxury Hotel South Sai Gon", "3.8 km"));
        nearbyList.add(new Nearby(R.drawable.saigon2, "Luxvoy Hotel and Tower Sai Gon", "4.2 km"));
        nearbyList.add(new Nearby(R.drawable.saigon1, "Luxvoy Hotel South Sai Gon", "3.6 km"));

//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_booking, container, false);

        return rootview;
    }
}