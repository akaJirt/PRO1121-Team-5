package com.example.hotel_luxvoy.models;

public class Nearby {
    private int saigon;
    private String name;
    private String distance;

    public Nearby() {
    }

    public int getSaigon() {
        return saigon;
    }

    public void setSaigon(int saigon) {
        this.saigon = saigon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Nearby(int saigon, String name, String distance) {
        this.saigon = saigon;
        this.name = name;
        this.distance = distance;
    }

}
