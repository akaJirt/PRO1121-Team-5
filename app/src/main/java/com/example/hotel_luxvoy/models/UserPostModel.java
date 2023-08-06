package com.example.hotel_luxvoy.models;

public class UserPostModel implements java.io.Serializable{


    private String phoneNumber;
    private String password;
    private String fullName;
    private String role ;
    private String street;
    private String ward;
    private String district;

    public UserPostModel(String phoneNumber, String password, String fullName, String role, String street, String ward, String district) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.street = street;
        this.ward = ward;
        this.district = district;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
