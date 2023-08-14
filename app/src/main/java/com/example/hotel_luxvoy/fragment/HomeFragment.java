package com.example.hotel_luxvoy.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.activity.BookCheckActivity;
import com.example.hotel_luxvoy.activity.HomeActivity;
import com.example.hotel_luxvoy.adapter.ExploreAdaper;
import com.example.hotel_luxvoy.adapter.MoreAdapter;
import com.example.hotel_luxvoy.adapter.ViewedAdapter;
import com.example.hotel_luxvoy.models.Explore;
import com.example.hotel_luxvoy.models.More;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.Viewed;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    TextView textView, tvUsername;
    ImageView imgBookNow;
    RecyclerView recyclerViewViewed, recyclerViewMore, recyclerViewExplore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        textView = rootView.findViewById(R.id.tvBooking);
        tvUsername = rootView.findViewById(R.id.tvUsername);
        Intent intent1 = getActivity().getIntent();

        //get data from SharePreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        UserAfterCheckLG userAfterCheckLG = new UserAfterCheckLG();
        if (!user.isEmpty()) {
            Gson gson = new Gson();
            userAfterCheckLG = gson.fromJson(user, UserAfterCheckLG.class);
        } else {
            userAfterCheckLG.setFullName("Guest");
        }

        tvUsername.setText(userAfterCheckLG.getFullName());
        String fullText = "It's time to switch off";
        String targetText = "switch off";
        int startIndex = fullText.indexOf(targetText);
        int endIndex = startIndex + targetText.length();

        SpannableString spannableString = new SpannableString(fullText);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#FFA500")); // Màu cam
        spannableString.setSpan(colorSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);

        imgBookNow = rootView.findViewById(R.id.imgBookNow);
        imgBookNow.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), BookCheckActivity.class);
            startActivity(intent);
        });

        recyclerViewViewed = rootView.findViewById(R.id.rvViewed);
        recyclerViewViewed.setHasFixedSize(true);
        recyclerViewViewed.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        List<Viewed> viewedList = new ArrayList<>();
        viewedList.add(new Viewed(R.drawable.img_viewed1, "Phu Quoc Beach, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed2, "Ha Long Bay, Luxvoy Collection"));
        viewedList.add(new Viewed(R.drawable.img_viewed3, "Ha Giang, Luxvoy Collection"));

        ViewedAdapter viewedAdapter = new ViewedAdapter(viewedList, getActivity());
        recyclerViewViewed.setAdapter(viewedAdapter);

        recyclerViewMore = rootView.findViewById(R.id.rvMore);
        recyclerViewMore.setHasFixedSize(true);
        recyclerViewMore.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<More> moreList = new ArrayList<>();
        moreList.add(new More(R.drawable.img_more, null));
        moreList.add(new More(R.drawable.img_more2, null));
        moreList.add(new More(R.drawable.img_more, null));

        MoreAdapter moreAdapter = new MoreAdapter(moreList, getActivity());
        recyclerViewMore.setAdapter(moreAdapter);

        recyclerViewExplore = rootView.findViewById(R.id.rvExplore);
        recyclerViewExplore.setHasFixedSize(true);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        List<Explore> exploreList = new ArrayList<>();
        exploreList.add(new Explore(R.drawable.img_explore, "Ha Noi explore"));
        exploreList.add(new Explore(R.drawable.img_explore2, "Ho Chi Minh explore"));
        exploreList.add(new Explore(R.drawable.img_explore3, "Nha Trang explore"));

        ExploreAdaper exploreAdaper = new ExploreAdaper(exploreList, getActivity());
        recyclerViewExplore.setAdapter(exploreAdaper);


        return rootView;
    }
}
