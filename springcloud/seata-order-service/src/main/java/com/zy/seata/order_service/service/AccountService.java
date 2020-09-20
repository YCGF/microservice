package com.zy.seata.order_service.service;

import com.zy.seata.order_service.domain.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping(value = "/api/v1/account/decrease", method = RequestMethod.POST)
    Response decrease(@RequestParam("userId") int userId, @RequestParam("price") double price);
}
