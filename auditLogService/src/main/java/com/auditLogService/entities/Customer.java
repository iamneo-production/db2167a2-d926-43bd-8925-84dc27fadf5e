package com.auditLogService.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Customer {

    private String customerId;
    private String customerName;
    private String password;
    private boolean flag;
    private double balance;
    private String email;
}
