package com.example.hotel_luxvoy.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel implements java.io.Serializable{

    private String _id;
    private String hotelName;
    private ArrayList<String> image;
    private String rating;
    private String lowestPrice;
    private String userId;
    private ArrayList<Room> rooms;

    public Hotel(String _id, String hotelName, ArrayList<String> image, String rating, String lowestPrice, String userId, ArrayList<Room> rooms) {
        this._id = _id;
        this.hotelName = hotelName;
        this.image = image;
        this.rating = rating;
        this.lowestPrice = lowestPrice;
        this.userId = userId;
        this.rooms = rooms;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
