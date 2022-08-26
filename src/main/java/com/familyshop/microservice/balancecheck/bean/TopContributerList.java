package com.familyshop.microservice.balancecheck.bean;

import java.util.List;

public class TopContributerList {
    private List<CustomerSummary> in;
    private List<CustomerSummary> out;

    public List<CustomerSummary> getIn() {
        return in;
    }

    public void setIn(List<CustomerSummary> in) {
        this.in = in;
    }

    public List<CustomerSummary> getOut() {
        return out;
    }

    public void setOut(List<CustomerSummary> out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "TopContributerList{" +
                "in=" + in +
                ", out=" + out +
                '}';
    }
}
