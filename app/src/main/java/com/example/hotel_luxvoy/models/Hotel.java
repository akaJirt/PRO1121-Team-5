package com.example.hotel_luxvoy.models;

import java.util.List;

public class Hotel {

    private int hotelId;

    private int image;
    private String hotelName;
    private String hotelAddress;
    private String rating;

    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(int hotelId, int image, String hotelName, String hotelAddress, String rating, List<Room> rooms) {
        this.hotelId = hotelId;
        this.image = image;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.rating = rating;
        this.rooms = rooms;
    }

    public Hotel(int hotelId, int image, String hotelName, String hotelAddress, String rating) {
        this.hotelId = hotelId;
        this.image = image;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.rating = rating;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
