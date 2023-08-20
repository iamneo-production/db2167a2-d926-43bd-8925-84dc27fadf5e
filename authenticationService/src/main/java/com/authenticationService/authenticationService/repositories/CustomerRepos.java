package com.authenticationService.authenticationService.repositories;

import com.authenticationService.authenticationService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepos extends JpaRepository<Customer,String> {

}
