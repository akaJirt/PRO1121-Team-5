package com.example.hotel_luxvoy.adapter;

import static com.example.hotel_luxvoy.ServiceAPI.APIService.BASE_URL;

import android.content.Context;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_luxvoy.R;
import com.example.hotel_luxvoy.ServiceAPI.APIService;
import com.example.hotel_luxvoy.activity.BookLocationActivity;
import com.example.hotel_luxvoy.fragment.FragmentBook;
import com.example.hotel_luxvoy.models.Bill;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Trips;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripsViewHolder> {
    public enum FragmentType {
        CURRENT,
        PAST,
        CANCLED
    }

    private FragmentType fragmentType;

    public List<Trips> tripsList;

    public Context context;
    public ArrayList<Hotel> hotels;


    public TripsAdapter(List<Trips> tripsList, Context context, FragmentType fragmentType) {
        this.tripsList = tripsList;
        this.context = context;
        this.fragmentType = fragmentType;
    }

    @NonNull
    @Override
    public TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_trips, null);
        return new TripsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripsViewHolder holder, int position) {
        Trips trips = tripsList.get(position);
        getAllHotel();
        holder.tvHotelName.setText(trips.getHotelName());
        String description = trips.getDescription();
        String[] parts = description.split(" - ");
        String part1 = parts[0];
        String part2 = parts[1];

        holder.tvDescription.setText(totalDate(part1,part2));
        holder.tvConfirmation.setText(trips.getConfirmationNumber());
        holder.tvCancellation.setText(trips.getCancellationNumber());
//        holder.imgTrips.setImageResource(trips.getImage());
        Picasso.get()
                .load(trips.getImage())
                .into(holder.imgTrips);

        switch (fragmentType) {
            case CURRENT:
                holder.btnTrips.setText("Details");
                holder.tvCancellation.setVisibility(View.GONE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentBook fragmentBook = new FragmentBook();
                        Bundle bundle = new Bundle();
                        bundle.putString("hotelName", trips.getHotelName());
                        bundle.putString("description", trips.getDescription());
                        bundle.putString("confirmationNumber", trips.getConfirmationNumber());
                        bundle.putString("cancellationNumber", trips.getCancellationNumber());
                        bundle.putString("image", trips.getImage());
                        SharedPreferences sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                        String user = sharedPreferences.getString("user", "");
                        UserAfterCheckLG userAfterCheckLG = new UserAfterCheckLG();
                        Gson gson = new Gson();
                        userAfterCheckLG = gson.fromJson(user, UserAfterCheckLG.class);
                        String[] parts = trips.getConfirmationNumber().split(" ");
                        Log.d(">>>>>>>>>>>>>>>>>", "onClick: "+trips.getConfirmationNumber());
                        String part1 = parts[2];
                        Log.d(">>>>>>>>>>>>>>>>>>", "onClick: "+part1);
                        for (int i = 0; i < userAfterCheckLG.getBills().size(); i++) {
                            if (userAfterCheckLG.getBills().get(i).getBillStatus().equals("pending")) {

                                if (userAfterCheckLG.getBills().get(i).get_id().equals(part1)) {
                                    String idHotel = userAfterCheckLG.getBills().get(i).getRoom().getHotelId();
                                    for (int j = 0; j < hotels.size(); j++) {
                                        if (hotels.get(j).get_id().equals(idHotel)) {
                                            SharedPreferences sharedPreferences1 = context.getSharedPreferences("hotel", Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharedPreferences1.edit();
                                            Gson gson1 = new Gson();
                                            Hotel test= hotels.get(j);
                                            String hotel = gson1.toJson((Hotel)test);

                                            SharedPreferences sharedPreferences2 = context.getSharedPreferences("bill", Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor1 = sharedPreferences2.edit();
                                            Gson gson2 = new Gson();
                                            Bill bill1 = userAfterCheckLG.getBills().get(i);
                                            String bill = gson2.toJson(bill1);
                                            editor1.putString("bill", bill);
                                            bundle.putSerializable("bill", bill1);
                                            editor.putString("hotel", hotel);
                                            editor.commit();
                                            editor1.commit();


                                        }

                                    }

                                }

                            }
                        }
                        fragmentBook.setArguments(bundle);
                        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, fragmentBook)
                                .addToBackStack(null)
                                .commit();
                    }
                });
                break;
            case PAST:
                holder.btnTrips.setText("Rebook");
                holder.tvConfirmation.setVisibility(View.GONE);
                holder.tvCancellation.setVisibility(View.GONE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BookLocationActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case CANCLED:
                holder.btnTrips.setText("Rebook a room");
                holder.tvCancellation.setVisibility(View.VISIBLE);
                holder.btnTrips.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BookLocationActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    public class TripsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTrips;

        TextView tvHotelName, tvDescription, tvConfirmation, tvCancellation;

        Button btnTrips;

        public TripsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTrips = itemView.findViewById(R.id.imgTrips);
            tvHotelName = itemView.findViewById(R.id.tvHotelName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvConfirmation = itemView.findViewById(R.id.tvConfirmation);
            tvCancellation = itemView.findViewById(R.id.tvCancellation);
            btnTrips = itemView.findViewById(R.id.btnTrips);
        }
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
        String ngay1 = part13.substring(0,2);
        cal1.set(Integer.parseInt(Nam1),Integer.parseInt(Thang1),Integer.parseInt(ngay1));
        //tách date 2 lấy ngày tháng năm
        String[] parts2 = part2.split("-");
        String Nam2 = parts2[0];
        String Thang2 = parts2[1];
        String part23 = parts2[2];
        String ngay2 = part23.substring(0,2);
        cal2.set(Integer.parseInt(Nam2),Integer.parseInt(Thang2),Integer.parseInt(ngay2));
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
            return monthName+", "+ngay1+"-"+ngay2+" ("+String.valueOf(daysDifference+1)+" Days)";
        }
        else {
            int monthNumber = cal1.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            int monthNumber2 = cal2.get(Calendar.MONTH); // Số tháng (từ 1 đến 12)
            return monthNumber+"-"+monthNumber2+", "+ngay1+"-"+ngay2+" ("+String.valueOf(daysDifference+1)+" Days)";
        }

    }

    private void getAllHotel(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Call<ArrayList<Hotel>> call = apiService.getAllHotel();
        call.enqueue(new Callback<ArrayList<Hotel>>() {
            @Override
            public void onResponse(Call<ArrayList<Hotel>> call, Response<ArrayList<Hotel>> response) {
                hotels = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Hotel>> call, Throwable t) {


            }
        });


    }


}
