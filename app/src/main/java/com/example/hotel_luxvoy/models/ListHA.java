package com.example.hotel_luxvoy.models;

public class ListHA {
    private int Picture;
    private String text;

    public ListHA(int picture, String text) {
        Picture = picture;
        this.text = text;
    }

    public int getPicture() {
        return Picture;
    }

    public String getText() {
        return text;
    }
}
