package com.familyshop.microservice.balancecheck.bean;

public class CustomerSummary {

    private String id;
    private String name;
    private int amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomerSummary{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
