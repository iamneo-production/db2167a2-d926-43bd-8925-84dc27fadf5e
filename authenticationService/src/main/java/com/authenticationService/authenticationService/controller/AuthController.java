package com.authenticationService.authenticationService.controller;

import com.authenticationService.authenticationService.entities.Customer;
import com.authenticationService.authenticationService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin

public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/autenticate/")
    public Customer validate(@RequestBody Customer customer){
        Optional<Customer> isValid = this.authService.validateCustomer(customer);
        if(isValid.isPresent()){
            customer.setFlag(true);
            customer.setCustomerName(isValid.get().getCustomerName());
            customer.setBalance(isValid.get().getBalance());
            customer.setEmail(isValid.get().getEmail());
            return (customer);
        }
        return customer;

    }
}
