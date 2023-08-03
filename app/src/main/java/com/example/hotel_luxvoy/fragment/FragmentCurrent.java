package com.example.hotel_luxvoy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.RCV1Adapter;
import com.example.hotel_luxvoy.adapter.RcvCurrentAdapter;
import com.example.hotel_luxvoy.models.Current;
import com.example.hotel_luxvoy.models.ListHA;

import java.util.ArrayList;
import java.util.List;

public class FragmentCurrent extends Fragment {

    private RecyclerView rcvcurrent ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current, container , false);
        rcvcurrent = view.findViewById(R.id.rcvcurrent);
        rcvcurrent.setHasFixedSize(true);
        rcvcurrent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Current> mCurrent = new ArrayList<>();
        mCurrent.add(new Current(R.drawable.img, "Luxvoy Luxury Ha Noi Hotel","Sep 11-14 (3 nights)","Confirmation number: 98581885" ));
        RcvCurrentAdapter rcvCurrentAdapter = new RcvCurrentAdapter(mCurrent, getActivity());
        rcvcurrent.setAdapter(rcvCurrentAdapter);


        return view;


    }

}

