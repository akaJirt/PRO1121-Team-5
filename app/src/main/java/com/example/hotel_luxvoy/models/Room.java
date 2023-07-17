package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class Room implements java.io.Serializable{

    private int roomId;

    private ArrayList<imageModel> images;
    private String type;
    private String price;
    private String status;
    private String capacity;


    public Room(int roomId, ArrayList<imageModel> images, String type, String price, String status, String capacity) {
        this.roomId = roomId;
        this.images = images;
        this.type = type;
        this.price = price;
        this.status = status;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public ArrayList<imageModel> getImages() {
        return images;
    }

    public void setImages(ArrayList<imageModel> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
