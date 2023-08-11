package com.example.hotel_luxvoy.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel implements java.io.Serializable{

//    "_id": "64c8869497e7dd34e7f5e3c4",
//            "hotelName": "Pullman",
//            "image": [],
//            "street": "11 Phạm Ngũ Lão",
//            "ward": "phường 7",
//            "district": "Quận 1",
//            "city": "Hồ Chí Minh",
//            "rating": "3",
//            "lowestPrice": "300$",
//            "userId": "64c17d353d16fe7c01b7728c",
//            "rooms": []

    private String _id;
    private String hotelName;
    private ArrayList<String> image;
    private String street;
    private String ward;
    private String district;
    private String city;
    private String rating;
    private String lowestPrice;
    private String userId;
    private ArrayList<Room> rooms;

    public Hotel(String _id, String hotelName, ArrayList<String> image, String street, String ward, String district, String city, String rating, String lowestPrice, String userId, ArrayList<Room> rooms) {
        this._id = _id;
        this.hotelName = hotelName;
        this.image = image;
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.city = city;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
