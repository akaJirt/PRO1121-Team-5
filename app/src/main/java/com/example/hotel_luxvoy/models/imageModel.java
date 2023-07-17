package com.example.hotel_luxvoy.models;

public class imageModel implements java.io.Serializable{
    private String linkImg;

    public imageModel(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}
