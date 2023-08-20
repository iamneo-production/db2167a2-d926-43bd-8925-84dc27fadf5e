package com.auditLogService.services;

import com.auditLogService.entities.Customer;
import com.auditLogService.entities.LogDetail;

public interface logService {
    LogDetail createLog(Customer customer);
}
