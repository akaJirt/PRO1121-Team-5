package com.example.hotel_luxvoy.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.BookDatesActivity;
import com.example.hotel_luxvoy.activity.BookLocationActivity;
import com.example.hotel_luxvoy.adapter.ExploreAdaper;
import com.example.hotel_luxvoy.adapter.LuxuryAdapter;
import com.example.hotel_luxvoy.adapter.NearbyAdapter;
import com.example.hotel_luxvoy.adapter.PremiumAdapter;
import com.example.hotel_luxvoy.adapter.ViewedAdapter;
import com.example.hotel_luxvoy.models.Explore;
import com.example.hotel_luxvoy.models.Luxury;
import com.example.hotel_luxvoy.models.Nearby;
import com.example.hotel_luxvoy.models.Premium;
import com.example.hotel_luxvoy.models.Viewed;

import java.util.ArrayList;
import java.util.List;


public class BookingFragment extends Fragment {

    RecyclerView rvNearby, rvViewed, rvDestination, rvLuxury, rvPremium;

    LinearLayout layoutLocation, layoutDates;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_booking, container, false);

        rvNearby = rootView.findViewById(R.id.rvNearby);
        rvNearby.setHasFixedSize(true);
        rvNearby.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Nearby> nearbyList = new ArrayList<>();
        nearbyList.add(new Nearby(R.drawable.saigon1, "Luxvoy Luxury Hotel South Sai Gon", "3.8 Km"));
        nearbyList.add(new Nearby(R.drawable.saigon2, "Luxvoy Luxury Hotel South Sai Gon 2", "4.8 Km"));
        nearbyList.add(new Nearby(R.drawable.saigon3, "Luxvoy Luxury Hotel South Sai Gon 3", "5.8 Km"));

        NearbyAdapter nearbyAdapter = new NearbyAdapter(nearbyList, getActivity());
        rvNearby.setAdapter(nearbyAdapter);

        rvViewed = rootView.findViewById(R.id.rvViewed);
        rvViewed.setHasFixedSize(true);
        rvViewed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Viewed> viewedList = new ArrayList<>();
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Phu Quoc Beach, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Ha Long Bay, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Da Nang Beach, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Nha Trang Beach, Luxvoy Collection"));

        ViewedAdapter viewedAdapter = new ViewedAdapter(viewedList, getActivity());
        rvViewed.setAdapter(viewedAdapter);

        rvDestination = rootView.findViewById(R.id.rvDestinations);
        rvDestination.setHasFixedSize(true);
        rvDestination.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Explore> exploreList = new ArrayList<>();
        exploreList.add(new Explore(R.drawable.img_explore, "Ha Noi explore"));
        exploreList.add(new Explore(R.drawable.img_explore, "Da Nang explore"));
        exploreList.add(new Explore(R.drawable.img_explore, "Nha Trang explore"));

        ExploreAdaper exploreAdaper = new ExploreAdaper(exploreList, getActivity());
        rvDestination.setAdapter(exploreAdaper);

        rvLuxury = rootView.findViewById(R.id.rvLuxury);
        rvLuxury.setHasFixedSize(true);
        rvLuxury.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Luxury> luxuryList = new ArrayList<>();
        luxuryList.add(new Luxury(R.drawable.premium1, "Luxury Hotel 1"));
        luxuryList.add(new Luxury(R.drawable.premium2, "Luxury Hotel 2"));
        luxuryList.add(new Luxury(R.drawable.premium3, "Luxury Hotel 3"));

        LuxuryAdapter luxuryAdapter = new LuxuryAdapter(luxuryList, getActivity());
        rvLuxury.setAdapter(luxuryAdapter);

        rvPremium = rootView.findViewById(R.id.rvPremium);
        rvPremium.setHasFixedSize(true);
        rvPremium.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List< Premium > premiumList = new ArrayList<>();
        premiumList.add(new Premium(R.drawable.premium3, "Premium Hotel 1"));
        premiumList.add(new Premium(R.drawable.premium4, "Premium Hotel 2"));
        premiumList.add(new Premium(R.drawable.premium2, "Premium Hotel 3"));

        PremiumAdapter premiumAdapter = new PremiumAdapter(premiumList, getActivity());
        rvPremium.setAdapter(premiumAdapter);

        layoutLocation = rootView.findViewById(R.id.layoutLoca);
        layoutLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookLocationActivity.class));
            }
        });

        layoutDates = rootView.findViewById(R.id.layoutDates);

        layoutDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BookDatesActivity.class));
            }
        });
        return rootView;
    }
}