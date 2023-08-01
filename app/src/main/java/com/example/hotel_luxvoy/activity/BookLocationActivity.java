package com.example.hotel_luxvoy.activity;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.models.Hotel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookLocationActivity extends AppCompatActivity {

    ArrayList<Hotel> hotelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_booking_location);

        geArrayListHotel();


    }

    private void geArrayListHotel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Call<ArrayList<Hotel>> call = apiService.getHotel();
        call.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                hotelArrayList = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {

            }
        });

    }
//    public ArrayList<Hotel> searchHotelsByAddress(String keyword) {
//        ArrayList<Hotel> searchResults = new ArrayList<>();
//        for (Hotel hotel : hotelArrayList) {
//            if (hotel.getAddress().contains(keyword)) {
//                searchResults.add(hotel);
//            }
//        }
//        return searchResults;
//    }
}