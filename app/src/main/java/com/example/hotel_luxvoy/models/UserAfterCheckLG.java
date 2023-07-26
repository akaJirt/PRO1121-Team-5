package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class UserAfterCheckLG implements java.io.Serializable{
    private String _id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String role;
    private ArrayList<Hotel> hotels;

    public UserAfterCheckLG(String _id, String username, String password, String fullName, String phoneNumber, String role, ArrayList<Hotel> hotels) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.hotels = hotels;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }
}
