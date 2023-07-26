package com.example.hotel_luxvoy.models;

public class Luxury {

    private int image;
    private String description;

    public Luxury() {
    }

    public Luxury(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
