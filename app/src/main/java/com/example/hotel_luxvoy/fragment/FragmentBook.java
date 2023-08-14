package com.example.hotel_luxvoy.fragment;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.adapter.RCV2Adapter;
import com.example.hotel_luxvoy.models.ArrayListHotel;
import com.example.hotel_luxvoy.models.Bill;
import com.example.hotel_luxvoy.models.Gallery;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentBook extends Fragment {
    private RecyclerView recyclerView2;

    ImageView ivCancel, ivBack, ivFavorite,ivHotel;
    TextView tvHotelName, tvCheckin,tvCheckout,tvConfirmation,tvTotaldate,tvAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);

        ivCancel = view.findViewById(R.id.ivCancel);
        ivBack = view.findViewById(R.id.ivBack);
        ivFavorite = view.findViewById(R.id.ivFavourite);
        ivHotel = view.findViewById(R.id.ivHotel);
        tvHotelName = view.findViewById(R.id.tvHotelName);
        tvCheckin = view.findViewById(R.id.tvCheckin);
        tvCheckout = view.findViewById(R.id.tvCheckout);
        tvConfirmation = view.findViewById(R.id.tvConfirmation);
        tvTotaldate = view.findViewById(R.id.tvTotaldate);
        tvAddress = view.findViewById(R.id.tvAddress);


        //get data from bundle
        Bundle bundle = getArguments();
        String hotelName = bundle.getString("hotelName");
        String description = bundle.getString("description");
        String confirmation = bundle.getString("confirmationNumber");
        String cancellation = bundle.getString("cancellationNumber");
        String image = bundle.getString("image");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bill", getActivity().MODE_PRIVATE);
        String billString = sharedPreferences.getString("bill", "");
        Gson gson = new Gson();
        Bill bill = gson.fromJson(billString, Bill.class);
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("hotel", getActivity().MODE_PRIVATE);
        String hotelString = sharedPreferences1.getString("hotel", "");
//        Log.d("TAG>>>>>>>>>>>>>>>>>>>>", "onCreateView: "+hotelString);
        //cắt ký tự [ đầu và cuối của chuỗi
//        hotelString = hotelString.substring(1, hotelString.length() - 1);

        Hotel hotel = gson.fromJson(hotelString, Hotel.class);


        //tách dữ liệu của description
        String[] parts = description.split(" - ");
        String part1 = parts[0];
        String part2 = parts[1];


        //format date

        //set data to view
        Picasso.get().load(image).into(ivHotel);
        tvHotelName.setText(hotelName);
        tvCheckin.setText(formatDate(part1));
        tvCheckout.setText(formatDate(part2));
        tvConfirmation.setText(confirmation);
        tvTotaldate.setText(totalDate(part1,part2));
        tvAddress.setText(hotel.getStreet()+", "+hotel.getDistrict()+", "+hotel.getCity());








        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requireActivity().getSupportFragmentManager() != null) {
                    requireActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
//        if(bill == null){
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            APIService apiService = retrofit.create(APIService.class);
//            Call<ArrayList<Bill>> call = apiService.getBillByStatus("pending");
//            call.enqueue(new Callback<ArrayList<Bill>>() {
//                @Override
//                public void onResponse(Call<ArrayList<Bill>> call, Response<ArrayList<Bill>> response) {
//                    ArrayList<Bill> bills = response.body();
//                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", getActivity().MODE_PRIVATE);
//                    String user = sharedPreferences.getString("user", "");
//                    Gson gson = new Gson();
//                    UserAfterCheckLG userAfterCheckLG = gson.fromJson(user, UserAfterCheckLG.class);
//                    for (int i = 0; i < bills.size(); i++) {
//                        if (bills.get(i).getBookedBy().equals(userAfterCheckLG.get_id())&&bills.get(i).getBillStatus().equals("pending")&&bills.get(i).get_id().equals(tvConfirmation.getText().toString())) {
//                            for (int j = 0; j < bills.get(i).getRoom().getRoomImages().size(); j++) {
//                                imageList.add(new SlideModel(bills.get(i).getRoom().getRoomImages().get(j), ScaleTypes.FIT));
//
//                            }
//                        }
//                    }
//                    Toast.makeText(getActivity(), "Call oke", Toast.LENGTH_SHORT).show();
//                    Log.d(">>>>>>>>>>>>>>>>>>>", "onResponse: "+bill);
//
//                }
//
//                @Override
//                public void onFailure(Call<ArrayList<Bill>> call, Throwable t) {
//                    for (int i = 0; i < bill.getRoom().getRoomImages().size(); i++) {
//                        imageList.add(new SlideModel(bill.getRoom().getRoomImages().get(i), ScaleTypes.FIT));
//                    }
//                }
//            });
//        }
//        else {
//            for (int i = 0; i < bill.getRoom().getRoomImages().size(); i++) {
//                imageList.add(new SlideModel(bill.getRoom().getRoomImages().get(i), ScaleTypes.FIT));
//            }
//        }
        imageList.add(new SlideModel(R.drawable.room_1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.room_2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.room_3, ScaleTypes.FIT));

        imageSlider.setImageList(imageList);

        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FramentDialog dialog = new FramentDialog(getContext());
                Bundle bundle1 = new Bundle();
                bundle1.putString("idbill", tvConfirmation.getText().toString());
                dialog.setArguments(bundle1);
                dialog.show(getChildFragmentManager(), "FragmentDialog");

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
        String[] parts = part1.split("-");
        String Nam1 = parts[0];
        String Thang1 = parts[1];
        String part13 = parts[2];
        String ngay1 = part13.substring(0, 2);
        cal1.set(Integer.parseInt(Nam1), Integer.parseInt(Thang1), Integer.parseInt(ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("-");
        String Nam2 = parts2[0];
        String Thang2 = parts2[1];
        String part23 = parts2[2];
        String ngay2 = part23.substring(0, 2);
        cal2.set(Integer.parseInt(Nam2), Integer.parseInt(Thang2), Integer.parseInt(ngay2));
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
            return monthName + ", " + ngay1 + "-" + ngay2 + " (" + String.valueOf(daysDifference + 1) + " Days)";
        } else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return monthNumber + "-" + monthNumber2 + ", " + ngay1 + "-" + ngay2 + " (" + String.valueOf(daysDifference + 1) + " Days)";
        }

    }


}
