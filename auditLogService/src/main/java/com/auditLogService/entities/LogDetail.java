package com.auditLogService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class LogDetail {
    @Id
    private String LogId;
    private String customerId;
    private String CustomerName;
    private String email;
}
