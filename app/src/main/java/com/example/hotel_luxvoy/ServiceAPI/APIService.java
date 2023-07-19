package com.example.hotel_luxvoy.ServiceAPI;

import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.UserLoginModel;
import com.example.hotel_luxvoy.models.UserModel;
import com.example.hotel_luxvoy.models.UserPostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
   public static final String BASE_URL = "http://192.168.1.139:6969/api/v1/";
    @GET("users")
    Call<ArrayList<UserModel>> getData();

    @GET("hotel")
    Call<ArrayList<Hotel>> getHotel();


    @POST("checklogin")
    Call<UserAfterCheckLG> checkLogin(@Body UserLoginModel userLoginModel);

    @POST("users")
    Call<UserPostModel> createUser(@Body UserPostModel user);

}
