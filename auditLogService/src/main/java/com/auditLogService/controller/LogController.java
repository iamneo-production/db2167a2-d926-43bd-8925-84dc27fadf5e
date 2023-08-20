package com.auditLogService.controller;

import com.auditLogService.entities.Customer;
import com.auditLogService.entities.LogDetail;
import com.auditLogService.repositories.LogRepo;
import com.auditLogService.services.logService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/audit")
public class LogController {

    @Autowired
    private logService logService;
    @Autowired
    private LogRepo logRepo;
    @PostMapping("/logs")
    public ResponseEntity<?> auditLog(@RequestBody Customer customer){
       LogDetail savedData = this.logService.createLog(customer);
        return new ResponseEntity<>(savedData, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LogDetail>> getAllDetail(){
        List<LogDetail> logDetailList = this.logRepo.findAll();
        return new ResponseEntity<>(logDetailList,HttpStatus.OK);
    }
}
