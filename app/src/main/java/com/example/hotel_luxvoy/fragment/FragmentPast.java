package com.example.hotel_luxvoy.fragment;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.activity.BookLocationActivity;
import com.example.hotel_luxvoy.adapter.TripsAdapter;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Trips;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentPast extends Fragment {

    RecyclerView rvPast;

    LinearLayout llNoData;

    ArrayList<Trips> tripsList;


    Button btnBook;

    UserAfterCheckLG userAfterCheckLG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_past, container, false);
        rvPast = rootView.findViewById(R.id.rvPast);
        rvPast.setHasFixedSize(true);
        llNoData = rootView.findViewById(R.id.llNoData);
        btnBook = rootView.findViewById(R.id.btnBook);

        Intent intent = getActivity().getIntent();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        userAfterCheckLG = new UserAfterCheckLG();
        if (!user.isEmpty()) {
            Gson gson = new Gson();
            userAfterCheckLG = gson.fromJson(user, UserAfterCheckLG.class);
        } else {
            Toast.makeText(getActivity(), "Please login first", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < userAfterCheckLG.getBills().size(); i++) {
            if (userAfterCheckLG.getBills().get(i).getBillStatus().equals("accepted")) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

                APIService apiService = retrofit.create(APIService.class);
                Call<ArrayList<Hotel>> call = apiService.getHotel();
                call.enqueue(new Callback<ArrayList<Hotel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                        ArrayList<Hotel> hotels = response.body();
                        tripsList = new ArrayList<>();

                        for (int i = 0; i < userAfterCheckLG.getBills().size(); i++) {
                            if (userAfterCheckLG.getBills().get(i).getBillStatus().equals("accepted")) {
                                for (int j = 0; j < hotels.size(); j++) {
                                    String hotelId = hotels.get(j).get_id().toString();
                                    String hotelIdinBill = userAfterCheckLG.getBills().get(i).getRoom().getHotelId().toString();

                                    if (hotels.get(j).get_id().toString().equals(userAfterCheckLG.getBills().get(i).getRoom().getHotelId().toString())) {
                                        tripsList.add(new Trips(hotels.get(j).getImage().get(0), hotels.get(j).getHotelName(), userAfterCheckLG.getBills().get(i).getCheckInDate() + " - " + userAfterCheckLG.getBills().get(i).getCheckOutDate(), "Confirmation number: " + userAfterCheckLG.getBills().get(i).get_id(), "Cancellation number: " + userAfterCheckLG.getBills().get(i).get_id()));
                                    }
                                }
                            }
                        }

                        // Kiểm tra và hiển thị dữ liệu
                        if (tripsList == null || tripsList.size() == 0) {
                            llNoData.setVisibility(View.VISIBLE);
                            rvPast.setVisibility(View.GONE);
                        } else {
                            llNoData.setVisibility(View.GONE);
                            rvPast.setVisibility(View.VISIBLE);

                            TripsAdapter tripsAdapter = new TripsAdapter(tripsList, getActivity(), TripsAdapter.FragmentType.CURRENT);
                            rvPast.setAdapter(tripsAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                        Toast.makeText(getActivity(), "Error+ cr", Toast.LENGTH_SHORT).show();

                        // Hiển thị thông báo lỗi khi API gặp vấn đề
                        llNoData.setVisibility(View.VISIBLE);
                        rvPast.setVisibility(View.GONE);
                    }

                });
            }

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
