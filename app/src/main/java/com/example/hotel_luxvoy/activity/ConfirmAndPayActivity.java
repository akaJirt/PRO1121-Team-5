package com.example.hotel_luxvoy.activity;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotel_luxvoy.FullScreenHelper;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.Book;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfirmAndPayActivity extends AppCompatActivity {
    ImageView ivBack,ivHotel,ivBookNow;
    TextView tvHotelName,tvDate,tvCapacity,tvTypeRoom;

    UserAfterCheckLG user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_confirm_and_pay);
        Intent intent = getIntent();
        Hotel hotel = (Hotel) intent.getSerializableExtra("hotel");
        Room room = (Room) intent.getSerializableExtra("room");
        ivHotel = findViewById(R.id.ivHotel);
        tvHotelName = findViewById(R.id.tvHotelName);
        tvDate = findViewById(R.id.tvDate);
        tvCapacity = findViewById(R.id.tvCapacity);
        tvTypeRoom = findViewById(R.id.tvTypeRoom);
        ivBookNow = findViewById(R.id.ivBookNow);
//        UserAfterCheckLG user = (UserAfterCheckLG) intent.getSerializableExtra("user");
        user = new UserAfterCheckLG();
        //get data from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String user1 = sharedPreferences.getString("user", "");
        if(!user1.isEmpty()) {
            Gson gson = new Gson();
            UserAfterCheckLG userAfterCheckLG = gson.fromJson(user1, UserAfterCheckLG.class);
            user = userAfterCheckLG;

        }


        tvHotelName.setText(hotel.getHotelName());
        Picasso.get().load(hotel.getImage().get(0)).into(ivHotel);
        String date = intent.getStringExtra("checkInDate") + " - " + intent.getStringExtra("checkOutDate");
        tvDate.setText(date);
        tvCapacity.setText(room.getCapacity() + " guests");
        tvTypeRoom.setText(room.getType());
//        String checkInDate = intent.getStringExtra("checkInDate");
//        String checkOutDate = intent.getStringExtra("checkOutDate");
//        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            Date inputcheckInDate = inputDateFormat.parse(checkInDate);
//            Date inputcheckOutDate = inputDateFormat.parse(checkOutDate);
//            String formattedDate = outputDateFormat.format(inputcheckInDate);
//            String formattedDate2 = outputDateFormat.format(inputcheckOutDate);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            onBackPressed();
        });

        ivBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

//                "hotelId": "string",
//                        "roomId": "string",
//                        "bookedBy": "string",
//                        "paymentMethod": "string",
//                        "checkInDate": "2023-08-08T07:39:17.483Z",
//                        "checkOutDate": "2023-08-08T07:39:17.483Z"
                APIService apiService = retrofit.create(APIService.class);
                Book book = new Book();
                book.setCheckInDate(intent.getStringExtra("checkInDate"));
                book.setCheckOutDate(intent.getStringExtra("checkOutDate"));
                book.setHotelId(hotel.get_id());
                book.setRoomId(room.get_id());
                book.setBookedBy(user.get_id());

                Call<Book> call = apiService.bookHotel(book);
                call.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Toast.makeText(ConfirmAndPayActivity.this, "Booked", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Toast.makeText(ConfirmAndPayActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}