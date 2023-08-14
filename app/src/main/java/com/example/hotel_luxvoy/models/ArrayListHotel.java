package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class ArrayListHotel implements java.io.Serializable{
    private ArrayList<Hotel> hotels;

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayListHotel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }
}
