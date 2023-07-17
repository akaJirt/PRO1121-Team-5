package com.example.hotel_luxvoy.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel implements java.io.Serializable{

    private int hotelId;
    private ArrayList<imageModel1> images;
    private String hotelName;
    private String rating;

    private String price;

    private ArrayList<Room> rooms;

    public Hotel() {
    }

    public Hotel(int hotelId, ArrayList<imageModel1> images, String hotelName, String rating, String price, ArrayList<Room> rooms) {
        this.hotelId = hotelId;
        this.images = images;
        this.hotelName = hotelName;
        this.rating = rating;
        this.price = price;
        this.rooms = rooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public ArrayList<imageModel1> getImages() {
        return images;
    }

    public void setImages(ArrayList<imageModel1> images) {
        this.images = images;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
