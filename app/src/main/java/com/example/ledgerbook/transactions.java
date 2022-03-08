package com.example.ledgerbook;

public class transactions {
    private String id;
    private String purpose;
    private  String amount;

    public transactions(String id, String purpose, String amount) {
        this.id = id;
        this.purpose = purpose;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
