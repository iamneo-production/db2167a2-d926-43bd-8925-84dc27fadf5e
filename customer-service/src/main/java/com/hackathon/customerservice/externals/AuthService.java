package com.hackathon.customerservice.externals;

import com.hackathon.customerservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthService {
    @PostMapping("/autenticate/")
    Optional<Customer> validateCustomer(@RequestBody Customer customer);
}
