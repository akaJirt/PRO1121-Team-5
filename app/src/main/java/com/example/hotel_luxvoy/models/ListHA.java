package com.example.hotel_luxvoy.models;

public class ListHA {
    int Picture;
    String text;

    public ListHA(int picture, String text) {
        Picture = picture;
        this.text = text;
    }
    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
