package com.hackathon.customerservice.service;


import com.hackathon.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getByCustomerId(String customerId);
    Optional<Customer> validateCustomerPassword(Customer customer);


}
