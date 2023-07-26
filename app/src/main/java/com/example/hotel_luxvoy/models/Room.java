package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class Room implements java.io.Serializable{

    private String roomName;

   private String type;
   private String status;
   private String price;
   private String capacity;
   private ArrayList<String> roomImages;
   private String _id;

    public Room(String roomName, String type, String status, String price, String capacity, ArrayList<String> roomImages, String _id) {
        this.roomName = roomName;
        this.type = type;
        this.status = status;
        this.price = price;
        this.capacity = capacity;
        this.roomImages = roomImages;
        this._id = _id;
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
}
