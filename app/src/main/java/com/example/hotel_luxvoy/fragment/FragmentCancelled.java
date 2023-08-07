package com.example.hotel_luxvoy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.BookLocationActivity;
import com.example.hotel_luxvoy.adapter.TripsAdapter;
import com.example.hotel_luxvoy.models.Trips;

import java.util.ArrayList;
import java.util.List;

public class FragmentCancelled extends Fragment {
    RecyclerView rvCancelled;
    LinearLayout llNoData;
    List<Trips> tripsList;
    Button btnBook;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cancelled, container, false);
        rvCancelled = rootView.findViewById(R.id.rvCancelled);
        rvCancelled.setHasFixedSize(true);
        llNoData = rootView.findViewById(R.id.llNoData);
        btnBook = rootView.findViewById(R.id.btnBook);

        tripsList = new ArrayList<>();

        tripsList.add(new Trips(R.drawable.img_trips, "Luxvoy Luxury Hotel South Sai Gon", "Sep 11-14 (3 nights)", "Confirmation number: 98581885", "Cancellation number: 98581885"));
        tripsList.add(new Trips(R.drawable.img_trips, "Luxvoy Luxury Hotel South Sai Gon 2", "Sep 11-14 (3 nights)", "Confirmation number: 98581885", "Cancellation number: 98581885"));

        if (tripsList == null || tripsList.size() == 0) {
            llNoData.setVisibility(View.VISIBLE);
            rvCancelled.setVisibility(View.GONE);
        } else {
            llNoData.setVisibility(View.GONE);
            rvCancelled.setVisibility(View.VISIBLE);

            TripsAdapter tripsAdapter = new TripsAdapter(tripsList, getActivity(), TripsAdapter.FragmentType.CANCLED);
            rvCancelled.setAdapter(tripsAdapter);
        }

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookLocationActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
