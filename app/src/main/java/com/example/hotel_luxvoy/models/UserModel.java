package com.example.hotel_luxvoy.models;

public class UserModel {
//    idUser int , userName varchar(255),
//    passWord varchar(255), fullName varchar(255),
//    phoneNumber int, district varchar(255), ward varchar(255), stress varchar(255)

    private int idUser;
    private String userName;
    private String passWord;
    private String fullName;
    private int phoneNumber;
    private String district;
    private String ward;
    private String stress;

    public UserModel(int idUser, String userName, String passWord, String fullName, int phoneNumber, String district, String ward, String stress) {
        this.idUser = idUser;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.ward = ward;
        this.stress = stress;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }
}
