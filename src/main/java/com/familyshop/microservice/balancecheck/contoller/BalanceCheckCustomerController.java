package com.familyshop.microservice.balancecheck.contoller;


import com.familyshop.microservice.balancecheck.bean.Customer;
import com.familyshop.microservice.balancecheck.dto.CustomerDTO;
import com.familyshop.microservice.balancecheck.service.BalanceCheckCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("customer")
public class BalanceCheckCustomerController {

    @Autowired
    BalanceCheckCustomerService service;

    @GetMapping("/all_cust")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customerDTOList = service.fetchAllCustomers();
        return new ResponseEntity(customerDTOList, HttpStatus.OK);
    }

    @GetMapping("/cust_details")
    public ResponseEntity<Customer> getCustomerDueDetails(@RequestParam("id") String id){
        Customer customerDetails = service.getUserPaymentDetails(id);
        return new ResponseEntity(customerDetails, HttpStatus.OK);
    }


    @PutMapping("/edit_cust_details")
    public ResponseEntity editCustomerDetails(@RequestParam("id") String custId, @RequestBody Customer updateCustomer){
        service.updateCustomerDetails(custId, updateCustomer);

        return new ResponseEntity("Customer Updated", HttpStatus.OK);
    }


    @DeleteMapping("/delete_cust_details")
    public ResponseEntity deleteCustomer(@RequestParam("id") String custId){
        boolean status = service.deleteCustomerFromDB(custId);
        if (status){
            return new ResponseEntity("Delete Customer", HttpStatus.OK);
        }

        return new ResponseEntity("Customer delete Failed", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    //TODO
    @PostMapping("/create_cust")
    public ResponseEntity createNewCustomer(@RequestBody Customer newCustomer){
        service.insertNewCustomer(newCustomer);
        return new ResponseEntity("Create Customer", HttpStatus.OK);
    }
}
