package com.familyshop.microservice.balancecheck.bean;

public class TransactionRequest {
    private String id;
    private String txnTimeStamp;
    private Integer amount;
    private boolean paid;
    private Integer remaining;

    private boolean disableTxn;

    private String note;

    private String lastUpdateTxnTimeStamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public boolean isDisableTxn() {
        return disableTxn;
    }

    public void setDisableTxn(boolean disableTxn) {
        this.disableTxn = disableTxn;
    }

    public String getTxnTimeStamp() {
        return txnTimeStamp;
    }

    public void setTxnTimeStamp(String txnTimeStamp) {
        this.txnTimeStamp = txnTimeStamp;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getLastUpdateTxnTimeStamp() {
        return lastUpdateTxnTimeStamp;
    }

    public void setLastUpdateTxnTimeStamp(String lastUpdateTxnTimeStamp) {
        this.lastUpdateTxnTimeStamp = lastUpdateTxnTimeStamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "id='" + id + '\'' +
                ", txnTimeStamp='" + txnTimeStamp + '\'' +
                ", amount=" + amount +
                ", paid=" + paid +
                ", remaining=" + remaining +
                ", disableTxn=" + disableTxn +
                ", note='" + note + '\'' +
                ", lastUpdateTxnTimeStamp='" + lastUpdateTxnTimeStamp + '\'' +
                '}';
    }
}
