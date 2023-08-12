package com.example.hotel_luxvoy.ServiceAPI;

import com.example.hotel_luxvoy.models.Bill;
import com.example.hotel_luxvoy.models.Hotel;
import com.example.hotel_luxvoy.models.Room;
import com.example.hotel_luxvoy.models.UserAfterCheckLG;
import com.example.hotel_luxvoy.models.UserLoginModel;
import com.example.hotel_luxvoy.models.UserModel;
import com.example.hotel_luxvoy.models.UserPostModel;
import com.example.hotel_luxvoy.models.Book;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
   public static final String BASE_URL = "https://luxvoy-hotel-be.vercel.app/auth/";
    @GET("users")
    Call<ArrayList<UserModel>> getData();

    @GET("get-hotels")
    Call<ArrayList<Hotel>> getHotel();


    @POST("login")
    Call<UserAfterCheckLG> checkLogin(@Body UserLoginModel userLoginModel);

    @POST("register")
    Call<UserPostModel> APIcreateUser(@Body UserPostModel user);

    @GET("{city}/hotels-by-city")
      Call<ArrayList<Hotel>> getHotelByCity(@Path("city") String city);

    @GET("{hotelId}/get-rooms")
      Call<ArrayList<Room>> getRoomByHotel(@Path("hotelId") String hotelId);

    @PUT("book-hotel")
    Call<Book> bookHotel(@Body Book book);

    @GET("{userId}/bills")
    Call<ArrayList<Bill>> getBillByUser(@Path("userId") String userId);


}
