package com.hackathon.accountservice.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String customerName;
    private double balance;
}
