package com.example.hotel_luxvoy.activity;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.adapter.HotelAdapter;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HotelActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HotelAdapter hotelAdapter;
    private ArrayList<Hotel> hotelList;
    private ArrayList<Room> roomList;

    private TextView tvHotelName, tvResult;

    private Spinner spSort;
    private String selectedLocation, checkInDate, checkOutDate;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_hotel);

        intent = getIntent();
        String hotelName = intent.getStringExtra("nameDestination");
        selectedLocation = intent.getStringExtra("selectedLocation");
        checkInDate = intent.getStringExtra("checkInDate");
        checkOutDate = intent.getStringExtra("checkOutDate");

        tvHotelName = findViewById(R.id.tvHotelName);
        tvResult = findViewById(R.id.tvResult);
        spSort = findViewById(R.id.spSort);
        tvHotelName.setText(hotelName);

        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            finish();
        });
        gethotelList();
        recyclerView = findViewById(R.id.rvHotel);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // int[] roomImages = {R.drawable.room_1, R.drawable.room_2, R.drawable.room_3,
        // R.drawable.room_4};
        // int[] roomImages2 = {R.drawable.room_2, R.drawable.room_3,
        // R.drawable.room_1};
        // int[] roomImages3 = {R.drawable.room_3, R.drawable.room_1,
        // R.drawable.room_2};
        // int[] roomImages4 = {R.drawable.room_4, R.drawable.room_2,
        // R.drawable.room_3};
        //
        //
        //
        // roomList.add(new Room(1, roomImages, "1 King bed, guest room, Non-smoking",
        // "120 USD", "Trống", "2"));
        // roomList.add(new Room(2, roomImages2, "2 Twin/single bed, guest room,
        // Non-smoking", "140 USD", "Trống", "2"));
        // roomList.add(new Room(3, roomImages3, "Twin King bed, guest room,
        // Non-smoking", "150 USD", "Trống", "2"));
        // roomList.add(new Room(4, roomImages4, "1 King bed, guest room, Non-smoking",
        // "120 USD", "Trống", "2"));

        // hotelList = new ArrayList<>();
        // hotelList.add(new Hotel(1, R.drawable.hotel_1, "Luxvoy Luxury Hotel South Sai
        // Gon", "4.5", "120 USD / Night", roomList));
        //
        //
        // hotelAdapter = new HotelAdapter(hotelList, this);
        // recyclerView.setAdapter(hotelAdapter);
    }

    private void gethotelList() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Log.d("selectedLocation", "gethotelList: "+selectedLocation);
        if(selectedLocation == null) {
            selectedLocation = "default";
        }
            if (!selectedLocation.equals("default")) {
                Call<ArrayList<Hotel>> call = apiService.getHotelByCity(selectedLocation);
                call.enqueue(new Callback<ArrayList<Hotel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                        if (response.isSuccessful()) {
                            ArrayList<Hotel> hotelList = response.body();
                            Log.d("on call api>>>>>>>", "onResponse: " + response.body().toString());
                            hotelAdapter = new HotelAdapter(hotelList, HotelActivity.this, intent);
                            recyclerView.setAdapter(hotelAdapter);
                            tvResult.setText("Showing " + hotelList.size() + " results");

                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());
                    }
                });
            } else {
                Call<ArrayList<Hotel>> call = apiService.getHotel();
                call.enqueue(new Callback<ArrayList<Hotel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                        if (response.isSuccessful()) {
                            ArrayList<Hotel> hotelList = response.body();
                            Log.d("on call api>>>>>>>", "onResponse: " + response.body().toString());
                            hotelAdapter = new HotelAdapter(hotelList, HotelActivity.this, intent);
                            recyclerView.setAdapter(hotelAdapter);
                            tvResult.setText("Showing " + hotelList.size() + " results");

                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {
                        Log.d("TAG", "onFailure: " + t.getMessage());
                    }
                });
            }



    }
}
