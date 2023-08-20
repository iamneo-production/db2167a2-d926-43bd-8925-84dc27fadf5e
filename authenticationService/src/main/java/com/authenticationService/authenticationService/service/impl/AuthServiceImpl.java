package com.authenticationService.authenticationService.service.impl;


import com.authenticationService.authenticationService.entities.Customer;
import com.authenticationService.authenticationService.repositories.CustomerRepos;
import com.authenticationService.authenticationService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CustomerRepos customerRepo;
    @Override
    public Optional<Customer> getByCustomerId(String customerId) {
        Optional<Customer> isCustomerFound = this.customerRepo.findById(customerId);
        if(isCustomerFound.isEmpty()){
            return Optional.empty();
        }
        else {
            return isCustomerFound;
        }
    }

    @Override
    public Optional<Customer> validateCustomer(Customer customer) {
        String customerId = customer.getCustomerId();
        Optional<Customer> isCustomerFound = this.customerRepo.findById(customerId);
        Customer cc = new Customer();
        if(isCustomerFound.isEmpty()){
            return Optional.empty();
        }
        else {

            if(isCustomerFound.get().getPassword().equals(customer.getPassword())){
                System.out.println("balance :: "+isCustomerFound.get().getBalance());
                return isCustomerFound;
            }
            System.out.println("isCustomerFound :: "+isCustomerFound);
            return Optional.empty();
        }

    }
}
