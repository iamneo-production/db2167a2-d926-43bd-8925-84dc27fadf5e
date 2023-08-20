package com.hackathon.customerservice.service.impl;

import com.hackathon.customerservice.externals.AuthService;
import com.hackathon.customerservice.model.Customer;
import com.hackathon.customerservice.repository.CustomerRepo;
import com.hackathon.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AuthService authService;
    @Override
    public Optional<Customer> getByCustomerId(String customerId) {
        Optional<Customer> isCustomerFound = this.customerRepo.findById(customerId);
        return isCustomerFound;
    }

    @Override
    public Optional<Customer> validateCustomerPassword(Customer customer)
    {
        customer.setCustomerName("");
        customer.setFlag(false);
        Optional<Customer> validUser = this.authService.validateCustomer(customer);
        System.out.println("ValidUser :: "+validUser.get().getCustomerName());
        if(validUser.get().getCustomerName().equals("")){
            return Optional.empty();
        }
        customer.setFlag(true);
        customer.setCustomerName(validUser.get().getCustomerName());

        customer.setBalance(validUser.get().getBalance());
        customer.setEmail(validUser.get().getEmail());
        customerRepo.save(customer);
        return validUser;
    }
}
