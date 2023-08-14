package com.example.hotel_luxvoy.models;

public class BillChangeSTT implements java.io.Serializable{
//    "billId": "string",
//    "billStatus": "string"
    private String billId;
    private String billStatus;



    public BillChangeSTT(String billId, String billStatus) {
        this.billId = billId;
        this.billStatus = billStatus;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
