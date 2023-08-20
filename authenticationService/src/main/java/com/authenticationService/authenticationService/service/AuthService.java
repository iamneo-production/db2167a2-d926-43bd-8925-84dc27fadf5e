package com.authenticationService.authenticationService.service;




import com.authenticationService.authenticationService.entities.Customer;

import java.util.Optional;

public interface AuthService {
    Optional<Customer> getByCustomerId(String customerId);
    Optional<Customer> validateCustomer(Customer customer);

}
