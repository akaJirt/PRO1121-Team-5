package com.example.hotel_luxvoy.models;

public class imageModel1 implements java.io.Serializable{
    private String roomImages;

    public imageModel1(String roomImages) {
        this.roomImages = roomImages;
    }

    public String getRoomImages() {
        return roomImages;
    }

    public void setRoomImages(String roomImages) {
        this.roomImages = roomImages;
    }
}
