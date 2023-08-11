package com.example.hotel_luxvoy.models;

import java.util.ArrayList;

public class imageModel implements java.io.Serializable{
    private String image;

    public imageModel(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
