package com.familyshop.microservice.balancecheck.contoller;


import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.bean.CustomerRequest;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("customer")
public class BalanceCheckCustomerController {

    @Autowired
    BalanceCheckCustomerService service;

    @GetMapping("/all")
    public ResponseEntity getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        try{
            customerList = service.fetchAllCustomers();
        }catch (Exception e){
            return new ResponseEntity<String>("Error Occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(customerList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createNewCustomer(@RequestBody CustomerRequest newCustomer){
        try {
            service.insertNewCustomer(newCustomer);
        }catch (Exception e){
            return new ResponseEntity<String>("Error Occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity("Customer is created", HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity getCustomerDueDetails(@RequestParam("id") String id){
        Customer customer  = new Customer();
        try {
            customer = service.getUserPaymentDetails(id);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity editCustomerDetails(@RequestParam("id") String custId, @RequestBody CustomerRequest editCustDetails){
        try {
            service.updateCustomerDetails(custId, editCustDetails);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Customer "+custId+" Updated Successfully", HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@RequestParam("id") String custId){

        try {
            service.deleteCustomerFromDB(custId);
        }catch (Exception e){
            return new ResponseEntity("Customer delete Failed, Error Occurred: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity("Deleted Customer "+custId+" Successfully", HttpStatus.OK);


    }


}
