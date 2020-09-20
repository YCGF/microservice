package com.zy.seata.account_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceApplication.class, args);
    }

}
