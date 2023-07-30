package com.example.hotel_luxvoy.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.adapter.RCV2Adapter;
import com.example.hotel_luxvoy.models.Gallery;

import java.util.ArrayList;
import java.util.List;

public class FragmentBook extends Fragment {
    private static final String TAG = "FragmentBook";
    private RecyclerView  recyclerView2;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        ImageView ivCancelres = view.findViewById(R.id.ivCancelres);

        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.room_1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.room_2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.room_3, ScaleTypes.FIT));

        imageSlider.setImageList(imageList);

        ivCancelres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick : opening dialog");
                FramentDialog dialog = new FramentDialog();
                dialog.show(getChildFragmentManager(), "FramnetDialog");

            }
        });


        recyclerView2 = view.findViewById(R.id.rcvgallery);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Gallery> mGallery = new ArrayList<>();
        mGallery.add(new Gallery(R.drawable.img_13));
        mGallery.add(new Gallery(R.drawable.img_14));
        mGallery.add(new Gallery(R.drawable.img_13));
        mGallery.add(new Gallery(R.drawable.img_14));

        RCV2Adapter adapter = new RCV2Adapter(mGallery, getActivity());
        recyclerView2.setAdapter(adapter);

        return view;
    }
}
