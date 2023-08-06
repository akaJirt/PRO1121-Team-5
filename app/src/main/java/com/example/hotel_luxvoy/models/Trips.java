package com.example.hotel_luxvoy.models;

public class Trips {

    private int image;

    private String HotelName;

    private String Description;

    private String ConfirmationNumber;

    private String CancellationNumber;



    public Trips() {
    }

    public Trips(int image, String hotelName, String description, String confirmNumber, String cancelNumber) {
        this.image = image;
        HotelName = hotelName;
        Description = description;
        ConfirmationNumber = confirmNumber;
        CancellationNumber = cancelNumber;

    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
