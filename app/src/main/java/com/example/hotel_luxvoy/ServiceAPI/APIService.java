package com.example.hotel_luxvoy.ServiceAPI;

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

    @GET("users")
    Call<ArrayList<UserModel>> getData();

    @POST("checklogin")
    Call<UserLoginModel> checkLogin(@Body UserLoginModel userLoginModel);

    @POST("users")
    Call<UserPostModel> createUser(@Body UserPostModel user);

}
