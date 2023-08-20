package com.hackathon.accountservice.controller;

import com.hackathon.accountservice.entity.Customer;
import com.hackathon.accountservice.entity.CustomerResponse;
import com.hackathon.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{customerId}/balance")
    @CircuitBreaker(name = "accountService",fallbackMethod = "balanceCheckMethod")
    public ResponseEntity<?> getAccountBalanceByCustomerId(@PathVariable String customerId){
        Customer c = this.accountService.getAccountBalance(customerId);
        if(c.getCustomerName().equals("")) return new ResponseEntity<>("Try Again",HttpStatus.NOT_FOUND);
        CustomerResponse customerResponse = CustomerResponse.builder()
                                            .customerName(c.getCustomerName())
                                            .balance(c.getBalance())
                                            .build();
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    public ResponseEntity<?> balanceCheckMethod(String customerId, Exception ex) {


        return new ResponseEntity<>("Some serivces are Unavailable,Try again", HttpStatus.OK);

    }
}
