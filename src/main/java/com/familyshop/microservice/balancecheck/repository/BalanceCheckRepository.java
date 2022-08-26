package com.familyshop.microservice.balancecheck.repository;

import com.familyshop.microservice.balancecheck.bean.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceCheckRepository extends MongoRepository<Customer, String> {
}
