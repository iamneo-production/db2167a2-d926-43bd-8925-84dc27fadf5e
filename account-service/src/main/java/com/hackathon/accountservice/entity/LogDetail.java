package com.hackathon.accountservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class LogDetail {

    private String LogId;
    private String customerId;
    private String CustomerName;
    private String email;
}
