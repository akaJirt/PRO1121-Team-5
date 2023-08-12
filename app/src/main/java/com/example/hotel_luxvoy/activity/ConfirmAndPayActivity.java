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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfirmAndPayActivity extends AppCompatActivity {
    ImageView ivBack,ivHotel,ivBookNow;
    TextView tvHotelName,tvDate,tvCapacity,tvTypeRoom,tvDateStay,tvPrice,tvTotalPrice,tvServiceCharge,tvTaxesAndFee;

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
        tvDateStay = findViewById(R.id.tvDateStay);
        tvPrice = findViewById(R.id.tvPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvServiceCharge = findViewById(R.id.tvServiceCharge);
        tvTaxesAndFee = findViewById(R.id.tvTaxesAndFee);

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
        tvDateStay.setText(totalDate(intent.getStringExtra("checkInDate"),intent.getStringExtra("checkOutDate")));
        int totaldate = Integer.parseInt(totalDate1(intent.getStringExtra("checkInDate"),intent.getStringExtra("checkOutDate")));
        if(totaldate >=2) {
            //money unit is VND
            //ServiceCharge = 5% of total price
            //TaxesAndFee = 10% of total price
            int price = Integer.parseInt(room.getPrice())*totaldate;
            int serviceCharge = (int) (price*0.05);
            int taxesAndFee = (int) (price*0.1);
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price+" VND");
            tvServiceCharge.setText(serviceCharge+" VND");
            tvTaxesAndFee.setText(taxesAndFee+" VND");
            tvTotalPrice.setText(totalPrice+" VND");


        }
        else if(totaldate >=7){
            //money unit is VND
            //ServiceCharge = 10% of total price
            //TaxesAndFee = 15% of total price
            int price = Integer.parseInt(room.getPrice())*totaldate;
            int serviceCharge = (int) (price*0.1);
            int taxesAndFee = (int) (price*0.15);
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price+" VND");
            tvServiceCharge.setText(serviceCharge+" VND");
            tvTaxesAndFee.setText(taxesAndFee+" VND");
            tvTotalPrice.setText(totalPrice+" VND");

        }
        else {
            //money unit is VND
            //ServiceCharge = 0% of total price
            //TaxesAndFee = 0% of total price
            int price = Integer.parseInt(room.getPrice())*totaldate;
            int serviceCharge = 0;
            int taxesAndFee = 0;
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price+" VND");
            tvServiceCharge.setText(serviceCharge+" VND");
            tvTaxesAndFee.setText(taxesAndFee+" VND");
            tvTotalPrice.setText(totalPrice+" VND");

        }





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
                book.setCheckInDate(intent.getStringExtra("checkInDate")+"T00:00:00.000+07:00");
                book.setCheckOutDate(intent.getStringExtra("checkOutDate")+"T00:00:00.000+07:00");
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

    private String formatDate(String part1) {
        // Định dạng ban đầu của chuỗi ngày
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);

// Định dạng mới bạn muốn
        SimpleDateFormat outputFormat = new SimpleDateFormat("E, MMMM d, yyyy", Locale.ENGLISH);

        try {
            // Chuyển đổi chuỗi ngày gốc thành Date object
            Date date = inputFormat.parse(part1);

            // Chuyển đổi Date object thành chuỗi ngày mới với định dạng bạn mong muốn
            String formattedDate = outputFormat.format(date);

            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String totalDate(String part1, String part2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        //tách date 1 lấy ngày tháng năm
        String[] parts = part1.split("/");
        String Ngay1 = parts[0];
        String Thang1 = parts[1];
        String Nam1 = parts[2];

        cal1.set(Integer.parseInt(Nam1),Integer.parseInt(Thang1),Integer.parseInt(Ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("/");
        String Ngay2 = parts2[0];
        String Thang2 = parts2[1];
        String Nam2 = parts2[2];

        cal2.set(Integer.parseInt(Nam2),Integer.parseInt(Thang2),Integer.parseInt(Ngay2));
        // Trừ hai ngày với nhau
        long timeInMillis1 = cal1.getTimeInMillis();
        long timeInMillis2 = cal2.getTimeInMillis();
        long difference = timeInMillis2 - timeInMillis1;

// Chuyển đổi khoảng thời gian thành số ngày
        long daysDifference = difference / (24 * 60 * 60 * 1000);
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        if(cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){


            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)

            String monthName = monthNames[monthNumber - 1];
            return monthName+", "+Ngay1+"-"+Ngay2+" ("+String.valueOf(daysDifference+1)+" Days)";
        }
        else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return monthNumber+"-"+monthNumber2+", "+Ngay1+"-"+Ngay2+" ("+String.valueOf(daysDifference+1)+" Days)";
        }

    }
    private String totalDate1(String part1, String part2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        //tách date 1 lấy ngày tháng năm
        String[] parts = part1.split("/");
        String Ngay1 = parts[0];
        String Thang1 = parts[1];
        String Nam1 = parts[2];

        cal1.set(Integer.parseInt(Nam1),Integer.parseInt(Thang1),Integer.parseInt(Ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("/");
        String Ngay2 = parts2[0];
        String Thang2 = parts2[1];
        String Nam2 = parts2[2];

        cal2.set(Integer.parseInt(Nam2),Integer.parseInt(Thang2),Integer.parseInt(Ngay2));
        // Trừ hai ngày với nhau
        long timeInMillis1 = cal1.getTimeInMillis();
        long timeInMillis2 = cal2.getTimeInMillis();
        long difference = timeInMillis2 - timeInMillis1;

// Chuyển đổi khoảng thời gian thành số ngày
        long daysDifference = difference / (24 * 60 * 60 * 1000);
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        if(cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){


            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)

            String monthName = monthNames[monthNumber - 1];
            return String.valueOf(daysDifference+1);
        }
        else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return String.valueOf(daysDifference+1);
        }

    }
}