package com.example.hotel_luxvoy.models;

import java.lang.reflect.Array;

public class Trips {

    private String image;

    private String HotelName;

    private String Description;

    private String ConfirmationNumber;

    private String CancellationNumber;


    public Trips(String image, String hotelName, String description, String confirmationNumber, String cancellationNumber) {
        this.image = image;
        HotelName = hotelName;
        Description = description;
        ConfirmationNumber = confirmationNumber;
        CancellationNumber = cancellationNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getConfirmationNumber() {
        return ConfirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        ConfirmationNumber = confirmationNumber;
    }

    public String getCancellationNumber() {
        return CancellationNumber;
    }

    public void setCancellationNumber(String cancellationNumber) {
        CancellationNumber = cancellationNumber;
    }
}
