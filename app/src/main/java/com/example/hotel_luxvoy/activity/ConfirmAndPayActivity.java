package com.example.hotel_luxvoy.activity;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.momo.momo_partner.AppMoMoLib;

public class ConfirmAndPayActivity extends AppCompatActivity {
    ImageView ivBack, ivHotel, ivBookNow;
    TextView tvHotelName, tvDate, tvCapacity, tvTypeRoom, tvDateStay, tvPrice, tvTotalPrice, tvServiceCharge, tvTaxesAndFee;

    UserAfterCheckLG user;

    LinearLayout llPayment, llConfirm;

    Button btnBookNow;

    private String amount;
    private String merchantName = "Hotel Luxvoy";
    private String merchantCode = "MOMOOJOI20210710";
    private String merchantNameLabel = "Nhà cung cấp";
    private String description = "Thanh toán đặt phòng";

    Intent intent;
    Hotel hotel;

    Room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenHelper.setFullScreen(this);
        setContentView(R.layout.activity_confirm_and_pay);
        AppMoMoLib.getInstance().setEnvironment(AppMoMoLib.ENVIRONMENT.DEVELOPMENT);
        intent = getIntent();
        hotel = (Hotel) intent.getSerializableExtra("hotel");
        room = (Room) intent.getSerializableExtra("room");
        ivHotel = findViewById(R.id.ivHotel);
        tvHotelName = findViewById(R.id.tvHotelName);
        tvDate = findViewById(R.id.tvDate);
        tvCapacity = findViewById(R.id.tvCapacity);
        tvTypeRoom = findViewById(R.id.tvTypeRoom);
        btnBookNow = findViewById(R.id.btnBookNow);
        tvDateStay = findViewById(R.id.tvDateStay);
        tvPrice = findViewById(R.id.tvPrice);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvServiceCharge = findViewById(R.id.tvServiceCharge);
        tvTaxesAndFee = findViewById(R.id.tvTaxesAndFee);
        llPayment = findViewById(R.id.llPayment);
        llConfirm = findViewById(R.id.llConfirm);

//        UserAfterCheckLG user = (UserAfterCheckLG) intent.getSerializableExtra("user");
        user = new UserAfterCheckLG();
        //get data from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String user1 = sharedPreferences.getString("user", "");
        if (!user1.isEmpty()) {
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
        tvDateStay.setText(totalDate(intent.getStringExtra("checkInDate"), intent.getStringExtra("checkOutDate")));
        int totaldate = Integer.parseInt(totalDate1(intent.getStringExtra("checkInDate"), intent.getStringExtra("checkOutDate")));
        if (totaldate >= 2) {
            //money unit is VND
            //ServiceCharge = 5% of total price
            //TaxesAndFee = 10% of total price
            int price = Integer.parseInt(room.getPrice()) * totaldate;
            int serviceCharge = (int) (price * 0.05);
            int taxesAndFee = (int) (price * 0.1);
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price + " VND");
            tvServiceCharge.setText(serviceCharge + " VND");
            tvTaxesAndFee.setText(taxesAndFee + " VND");
            tvTotalPrice.setText(totalPrice + " VND");


        } else if (totaldate >= 7) {
            //money unit is VND
            //ServiceCharge = 10% of total price
            //TaxesAndFee = 15% of total price
            int price = Integer.parseInt(room.getPrice()) * totaldate;
            int serviceCharge = (int) (price * 0.1);
            int taxesAndFee = (int) (price * 0.15);
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price + " VND");
            tvServiceCharge.setText(serviceCharge + " VND");
            tvTaxesAndFee.setText(taxesAndFee + " VND");
            tvTotalPrice.setText(totalPrice + " VND");

        } else {
            //money unit is VND
            //ServiceCharge = 0% of total price
            //TaxesAndFee = 0% of total price
            int price = Integer.parseInt(room.getPrice()) * totaldate;
            int serviceCharge = 0;
            int taxesAndFee = 0;
            int totalPrice = price + serviceCharge + taxesAndFee;
            tvPrice.setText(price + " VND");
            tvServiceCharge.setText(serviceCharge + " VND");
            tvTaxesAndFee.setText(taxesAndFee + " VND");
            tvTotalPrice.setText(totalPrice + " VND");

        }


        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(v -> {
            onBackPressed();
        });

        llPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = tvTotalPrice.getText().toString().replace(" VND", "");
                requestPayment();
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

        cal1.set(Integer.parseInt(Nam1), Integer.parseInt(Thang1), Integer.parseInt(Ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("/");
        String Ngay2 = parts2[0];
        String Thang2 = parts2[1];
        String Nam2 = parts2[2];

        cal2.set(Integer.parseInt(Nam2), Integer.parseInt(Thang2), Integer.parseInt(Ngay2));
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
        if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {


            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)

            String monthName = monthNames[monthNumber - 1];
            return monthName + ", " + Ngay1 + "-" + Ngay2 + " (" + String.valueOf(daysDifference + 1) + " Days)";
        } else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return monthNumber + "-" + monthNumber2 + ", " + Ngay1 + "-" + Ngay2 + " (" + String.valueOf(daysDifference + 1) + " Days)";
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

        cal1.set(Integer.parseInt(Nam1), Integer.parseInt(Thang1), Integer.parseInt(Ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("/");
        String Ngay2 = parts2[0];
        String Thang2 = parts2[1];
        String Nam2 = parts2[2];

        cal2.set(Integer.parseInt(Nam2), Integer.parseInt(Thang2), Integer.parseInt(Ngay2));
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
        if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {


            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)

            String monthName = monthNames[monthNumber - 1];
            return String.valueOf(daysDifference + 1);
        } else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return String.valueOf(daysDifference + 1);
        }

    }

    private void requestPayment() {
        AppMoMoLib.getInstance().setAction(AppMoMoLib.ACTION.PAYMENT);
        AppMoMoLib.getInstance().setActionType(AppMoMoLib.ACTION_TYPE.GET_TOKEN);

        Map<String, Object> eventValue = new HashMap<>();
        eventValue.put("merchantname", merchantName); //Tên đối tác. được đăng ký tại https://business.momo.vn. VD: Google, Apple, Tiki , CGV Cinemas
        eventValue.put("merchantcode", merchantCode); //Mã đối tác, được cung cấp bởi MoMo tại https://business.momo.vn
        eventValue.put("amount", amount); //Kiểu integer
        eventValue.put("orderId", "orderId123456789"); //uniqueue id cho Bill order, giá trị duy nhất cho mỗi đơn hàng
        eventValue.put("orderLabel", "Mã đơn hàng"); //gán nhãn

        //client Optional - bill info
        eventValue.put("merchantnamelabel", "Dịch vụ");//gán nhãn
        eventValue.put("description", description);

        //client extra data
        eventValue.put("requestId", merchantCode + "merchant_billId_" + System.currentTimeMillis());
        eventValue.put("partnerCode", merchantCode);
        //Example extra data
        JSONObject objExtraData = new JSONObject();
        try {
            objExtraData.put("site_code", "008");
            objExtraData.put("site_name", "CGV Cresent Mall");
            objExtraData.put("screen_code", 0);
            objExtraData.put("screen_name", "Special");
            objExtraData.put("movie_name", "Kẻ Trộm Mặt Trăng 3");
            objExtraData.put("movie_format", "2D");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        eventValue.put("extraData", objExtraData.toString());

        eventValue.put("extra", "");
        AppMoMoLib.getInstance().requestMoMoCallBack(this, eventValue);


    }

    //Get token callback from MoMo app an submit to server side
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppMoMoLib.getInstance().REQUEST_CODE_MOMO && resultCode == -1) {
            if (data != null) {
                if (data.getIntExtra("status", -1) == 0) {
                    btnBookNow.setEnabled(false);
                    btnBookNow.setText("Đã thanh toán");
                    llConfirm.setVisibility(View.VISIBLE);
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

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
                            Toast.makeText(ConfirmAndPayActivity.this, "Đặt phòng thành công", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Book> call, Throwable t) {
                            Toast.makeText(ConfirmAndPayActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });


                    String token = data.getStringExtra("data"); //Token response
                    String phoneNumber = data.getStringExtra("phonenumber");
                    String env = data.getStringExtra("env");
                    if (env == null) {
                        env = "app";
                    }

                    if (token != null && !token.equals("")) {

                    } else {
                        Toast.makeText(this, "Not receive info", Toast.LENGTH_LONG).show();
                    }
                } else if (data.getIntExtra("status", -1) == 1) {

                    String message = data.getStringExtra("message") != null ? data.getStringExtra("message") : "Thất bại";
                    Toast.makeText(this, "123", Toast.LENGTH_SHORT).show();
                } else if (data.getIntExtra("status", -1) == 2) {
                    //TOKEN FAIL
                    Toast.makeText(this, "message:", Toast.LENGTH_SHORT).show();
                } else {
                    //TOKEN FAIL
                    Toast.makeText(this, "message:", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "message:", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "message:", Toast.LENGTH_SHORT).show();
        }
    }
}