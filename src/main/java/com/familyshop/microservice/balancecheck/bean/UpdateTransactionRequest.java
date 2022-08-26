package com.familyshop.microservice.balancecheck.bean;

public class UpdateTransactionRequest {

    private int payedAmount;
    private boolean disableTxn;
    private String note;

    public int getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(int payedAmount) {
        this.payedAmount = payedAmount;
    }

    public boolean isDisableTxn() {
        return disableTxn;
    }

    public void setDisableTxn(boolean disableTxn) {
        this.disableTxn = disableTxn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UpdateTransactionRequest{" +
                "payedAmount=" + payedAmount +
                ", disableTxn=" + disableTxn +
                ", note='" + note + '\'' +
                '}';
    }
}
