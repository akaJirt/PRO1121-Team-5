package com.example.hotel_luxvoy.models;

import java.util.Date;

public class Book implements java.io.Serializable {
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
    private Date checkInDate;
    private Date checkOutDate;

    private String totalPrice;

    public Book() {
    }


    public Book(String hotelId, String roomId, String bookedBy, String paymentMethod, Date checkInDate, Date checkOutDate, String totalPrice) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.bookedBy = bookedBy;
        this.paymentMethod = paymentMethod;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
