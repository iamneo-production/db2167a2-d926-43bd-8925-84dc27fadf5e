package com.hackathon.customerservice.controller;

import com.hackathon.customerservice.model.Customer;
import com.hackathon.customerservice.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{customerId}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "validateCustomerMethod")
    public ResponseEntity<?> getAccountBalanceByCustomerId(@RequestBody Customer customer,@PathVariable String customerId){

        Optional<Customer> c = this.customerService.getByCustomerId(customerId);
        if(c.equals(Optional.empty())){
            return new ResponseEntity<>("Customer Not Found",HttpStatus.NOT_FOUND);
        }
        //validate Customer
        Optional<Customer> isValid = this.customerService.validateCustomerPassword(customer);
        if(isValid.isPresent())
            return new  ResponseEntity<>("Authentication is SuccessFull",HttpStatus.OK);
        else if(isValid.equals(Optional.empty())) return new ResponseEntity<>("Customer not found",HttpStatus.NOT_FOUND);
        else return null;
    }
    public ResponseEntity<?> validateCustomerMethod(Customer customer,String customerId, Exception ex) {


        return new ResponseEntity<>("Authenetication serivce is Unavailable,Try again", HttpStatus.OK);

    }

}
