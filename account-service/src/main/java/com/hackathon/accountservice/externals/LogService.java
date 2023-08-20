package com.hackathon.accountservice.externals;

import com.hackathon.accountservice.entity.Customer;
import com.hackathon.accountservice.entity.LogDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "LOG-SERVICE")
public interface LogService {
    @PostMapping("/audit/logs")
    LogDetail createLog(Customer customer);
}
