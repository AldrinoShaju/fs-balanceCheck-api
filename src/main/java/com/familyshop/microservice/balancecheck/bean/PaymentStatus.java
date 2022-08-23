package com.familyshop.microservice.balancecheck.bean;

public class PaymentStatus {
    private String id;
    private Integer amount;
    private Boolean isPaid;
    private Integer remaining;

    public PaymentStatus() {
    }

    public PaymentStatus(String id, Integer amount, Boolean isPaid, Integer remaining) {
        this.id = id;
        this.amount = amount;
        this.isPaid = isPaid;
        this.remaining = remaining;
    }

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
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "PaymentStatusDTO{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                ", remaining=" + remaining +
                '}';
    }
}
