package com.hackathon.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String password;
    private boolean flag ;
    private String email;
    private double balance;
}
