package com.familyshop.microservice.balancecheck.service;

import com.familyshop.microservice.balancecheck.bean.TopContributerList;

import java.util.List;

public interface BalanceCheckDashboardService {

    public List<Integer> getDashBoardDetails();

    public TopContributerList getTopContributer();
}
