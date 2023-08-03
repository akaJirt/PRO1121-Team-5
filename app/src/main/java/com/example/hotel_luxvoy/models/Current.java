package com.example.hotel_luxvoy.models;

public class Current {
    private int img;
    private String namehotel;
    private String date;
    private String cfnumber;

    public Current(int img, String namehotel, String date, String cfnumber) {
        this.img = img;
        this.namehotel = namehotel;
        this.date = date;
        this.cfnumber = cfnumber;
    }

    public int getImg() {
        return img;
    }

    public String getNamehotel() {
        return namehotel;
    }

    public String getDate() {
        return date;
    }

    public String getCfnumber() {
        return cfnumber;
    }


}
