package com.familyshop.microservice.balancecheck.contoller;

import com.familyshop.microservice.balancecheck.bean.TopContributerList;
import com.familyshop.microservice.balancecheck.service.BalanceCheckDashboardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BalanceCheckDashboardController {

    @Autowired
    BalanceCheckDashboardService dashboardService;

    @GetMapping("dashboard")
    public ResponseEntity getbalanceStatus(){
        List<Integer> dashBoardData = new ArrayList<>();
        try{
           dashBoardData = dashboardService.getDashBoardDetails();
        }catch (Exception e){
            return new ResponseEntity("Error occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(dashBoardData, HttpStatus.OK);
    }

    @GetMapping("contributer")
    public ResponseEntity getTopContributer(){
        TopContributerList dashBoardData = new TopContributerList();
        try{
            dashBoardData = dashboardService.getTopContributer();
        }catch (Exception e){
            return new ResponseEntity("Error occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(dashBoardData, HttpStatus.OK);
    }
}
