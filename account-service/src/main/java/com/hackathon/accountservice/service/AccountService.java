package com.hackathon.accountservice.service;

import com.hackathon.accountservice.entity.Customer;


public interface AccountService {
    Customer getAccountBalance(String customerId);
}
