package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class Bill implements java.io.Serializable{
//    "paymentMethod": "Momo",
//            "totalPrice": 10500000,
//            "billStatus": "cancelled",
//            "room": {
//        "roomName": "Superior Twin Room",
//                "type": "2 giường đơn",
//                "status": "pending",
//                "price": 3500000,
//                "capacity": "4",
//                "roomImages": [
//        "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/79/2016/12/01042801/RoomSuites-Executive-Suite-King-e1548065261664.jpg",
//                "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/79/2016/12/01042824/RoomSuites-Executive-Suite-Living-Room-1-e1548065562479.jpg"
//          ],
//        "hotelId": "64ce8ba6dd44239110bf47dc",
//                "bookedBy": "64ce84d38054ce3dfca3ec15",
//                "_id": "64ce8ba6dd44239110bf47db"
//    },
//            "bookedBy": "64ce84d38054ce3dfca3ec15",
//            "checkInDate": "2023-08-05T19:55:12.383Z",
//            "checkOutDate": "2023-08-08T19:55:12.383Z",
//            "_id": "64ceaa1963dd778fb50d6acf"
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
