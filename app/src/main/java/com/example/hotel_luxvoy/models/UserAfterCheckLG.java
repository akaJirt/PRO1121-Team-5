package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class UserAfterCheckLG implements java.io.Serializable{

    //"_id": "64c17d353d16fe7c01b7728c",
    //    "username": "0937361929",
    //    "password": "Uyen6662003@",
    //    "fullName": "Trần Thảo Uyên",
    //    "phoneNumber": "0937361929",
    //    "role": "1",
    //    "hotels": [rooms": []],
    //    "bills": []
    private String _id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String role;
    private ArrayList<Hotel> hotels;
    private ArrayList<Bill> bills;

    public UserAfterCheckLG() {
    }

    public UserAfterCheckLG(String _id, String username, String password, String fullName, String phoneNumber, String role, ArrayList<Hotel> hotels, ArrayList<Bill> bills) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.hotels = hotels;
        this.bills = bills;
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

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }
}
