package com.example.hotel_luxvoy.models;

public class Book implements java.io.Serializable{
//    "hotelId": "string",
//            "roomId": "string",
//            "bookedBy": "string",
//            "paymentMethod": "string",
//            "checkInDate": "2023-08-08T07:30:21.338Z",
//            "checkOutDate": "2023-08-08T07:30:21.338Z"

    private String hotelId;
    private String roomId;
    private String bookedBy;
    private String paymentMethod;
    private String checkInDate;
    private String checkOutDate;

    public Book() {
    }


    public Book(String hotelId, String roomId, String bookedBy, String paymentMethod, String checkInDate, String checkOutDate) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.bookedBy = bookedBy;
        this.paymentMethod = paymentMethod;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
