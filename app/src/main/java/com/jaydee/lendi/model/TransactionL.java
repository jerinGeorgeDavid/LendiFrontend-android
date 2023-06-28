package com.jaydee.lendi.model;

public class TransactionL {
//    {
//        "type" : "LEND",
//            "isOpen" : "True",
//            "amount" : "1000",
//            "firstParty" : "vv",
//            "secondParty" : "jj",
//            "remarks" : "third transaction"
//    }


    public Long id;
    public String type;
    public boolean isOpen;
    public String remarks;

    public String firstParty;

    public String secondParty;

    public double amount;

    public String getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "TransactionL{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + isOpen +
                ", description='" + remarks + '\'' +
                '}';
    }
}
