package com.auditLogService.services;

import com.auditLogService.controller.LogController;
import com.auditLogService.entities.Customer;
import com.auditLogService.entities.LogDetail;
import com.auditLogService.repositories.LogRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class logServiceImpl implements logService {
    @Autowired
    private LogRepo logRepo;
    Logger logger = LoggerFactory.getLogger(logServiceImpl.class);
    public LogDetail createLog(Customer customer){
        logger.info("Customer Id : "+customer.getCustomerId() +" Customer Name : "+ customer.getCustomerName());
        LogDetail savedData = new LogDetail();
        savedData.setLogId(UUID.randomUUID().toString());
        savedData.setCustomerName(customer.getCustomerName());
        savedData.setCustomerId(customer.getCustomerId());
        savedData.setEmail(customer.getEmail());
        this.logRepo.save(savedData);
        return savedData;
    }
}
