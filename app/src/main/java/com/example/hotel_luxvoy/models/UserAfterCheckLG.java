package com.example.hotel_luxvoy.models;

public class UserAfterCheckLG implements java.io.Serializable{
//    {
//        "idUser": 5,
//            "userName": "0123456789",
//            "passWord": "@Zqa123456",
//            "fullName": "testName1",
//            "phoneNumber": 123456789,
//            "district": "12",
//            "ward": "6",
//            "stress": "testStress"
//    }
    private int idUser;
    private String userName;
    private String passWord;
    private String fullName;
    private int phoneNumber;
    private String district;
    private String ward;
    private String stress;

    public UserAfterCheckLG(int idUser, String userName, String passWord, String fullName, int phoneNumber, String district, String ward, String stress) {
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
