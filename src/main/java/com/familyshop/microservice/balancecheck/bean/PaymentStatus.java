package com.familyshop.microservice.balancecheck.bean;

public class PaymentStatus {
    private String id;
    private Integer amount;
    private Boolean paid;
    private Integer remaining;

    public PaymentStatus() {
    }

    public PaymentStatus(String id, Integer amount, Boolean Paid, Integer remaining) {
        this.id = id;
        this.amount = amount;
        this.paid = Paid;
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

    @Override
    public String toString() {
        return "PaymentStatusDTO{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", isPaid=" + paid +
                ", remaining=" + remaining +
                '}';
    }
}
