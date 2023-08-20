package com.hackathon.customerservice;

import com.hackathon.customerservice.model.Customer;
import com.hackathon.customerservice.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepo customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Customer customer_1 = new Customer();
//		customer_1.setCustomerId(UUID.randomUUID().toString());
//		customer_1.setCustomerName("Abhishek Kr");
//		customer_1.setPassword("Abhishek@");
//		customer_1.setFlag(false);
//		customer_1.setBalance(10000);
//		customer_1.setEmail("abhishek@gmail.com");
//		customerRepository.save(customer_1);
//
//		Customer customer_2 = new Customer();
//		customer_2.setCustomerId(UUID.randomUUID().toString());
//		customer_2.setCustomerName("Yuvraj Kr");
//		customer_2.setPassword("Yuvraj@");
//		customer_2.setFlag(false);
//		customer_2.setBalance(20000);
//		customer_2.setEmail("yuvraj@gmail.com");
//		customerRepository.save(customer_2);
	}
}
