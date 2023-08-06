package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class Room implements java.io.Serializable{

//     "_id": {
//        "$oid": "64ce8ba6dd44239110bf47db"
//    },
//            "roomName": "Superior Twin Room",
//            "type": "2 giường đơn",
//            "status": "pending",
//            "price": 3500000,
//            "capacity": "4",
//            "roomImages": [
//            "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/79/2016/12/01042801/RoomSuites-Executive-Suite-King-e1548065261664.jpg",
//            "https://d2e5ushqwiltxm.cloudfront.net/wp-content/uploads/sites/79/2016/12/01042824/RoomSuites-Executive-Suite-Living-Room-1-e1548065562479.jpg"
//            ],
//            "hotelId": "64ce8ba6dd44239110bf47dc",
//            "bookedBy": "64ce84d38054ce3dfca3ec15"

    private String roomName;

   private String type;
   private String status;
   private String price;
   private String capacity;
   private ArrayList<String> roomImages;
   private String _id;
   private String hotelId;
    private String bookedBy;

    public Room(String roomName, String type, String status, String price, String capacity, ArrayList<String> roomImages, String _id, String hotelId, String bookedBy) {
        this.roomName = roomName;
        this.type = type;
        this.status = status;
        this.price = price;
        this.capacity = capacity;
        this.roomImages = roomImages;
        this._id = _id;
        this.hotelId = hotelId;
        this.bookedBy = bookedBy;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public ArrayList<String> getRoomImages() {
        return roomImages;
    }

    public void setRoomImages(ArrayList<String> roomImages) {
        this.roomImages = roomImages;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
}
