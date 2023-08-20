package com.hackathon.accountservice.service.impl;


import com.hackathon.accountservice.entity.Customer;
import com.hackathon.accountservice.entity.LogDetail;
import com.hackathon.accountservice.entity.NotificationDetail;
import com.hackathon.accountservice.externals.LogService;
import com.hackathon.accountservice.externals.NotificationService;
import com.hackathon.accountservice.repository.CustomerReposi;
import com.hackathon.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private CustomerReposi accountServiceRepo;
    @Autowired
    private LogService logService;

    @Autowired
    private NotificationService notificationService;
    @Override
    public Customer getAccountBalance(String customerId) {
        Customer customerBalance = this.accountServiceRepo.findById(customerId).get();
        //authentication is successfull
        if(customerBalance.isFlag()){
            customerBalance.setFlag(false);
            LogDetail logDetail = this.logService.createLog(customerBalance);

            System.out.println("logDetail: "+ logDetail.getCustomerName());
            NotificationDetail notificationDetailSent = this.notificationService.sendNotification(customerBalance);
            System.out.println("notifID:" +notificationDetailSent.getNotificationId());
            accountServiceRepo.save(customerBalance);
            return customerBalance;
        }
        customerBalance.setCustomerName("");
        return customerBalance;
    }
}
