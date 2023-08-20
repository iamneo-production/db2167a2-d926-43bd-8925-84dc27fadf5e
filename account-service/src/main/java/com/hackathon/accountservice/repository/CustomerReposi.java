package com.hackathon.accountservice.repository;

import com.hackathon.accountservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerReposi extends JpaRepository<Customer,String> {
}
