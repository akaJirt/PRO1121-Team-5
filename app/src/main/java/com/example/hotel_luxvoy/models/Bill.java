package com.example.hotel_luxvoy.models;

public class Bill implements java.io.Serializable{

    private String paymentMethod;
    private int totalPrice;
    private String billStatus;
    private Room room;
    private String bookedBy;
    private String checkInDate;
    private String checkOutDate;
    private String _id;

    public Bill(String paymentMethod, int totalPrice, String billStatus, Room room, String bookedBy, String checkInDate, String checkOutDate, String _id) {
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
        this.billStatus = billStatus;
        this.room = room;
        this.bookedBy = bookedBy;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this._id = _id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
