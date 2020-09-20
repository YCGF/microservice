package com.zy.seata.order_service.service;

import com.zy.seata.order_service.domain.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @RequestMapping(value = "/api/v1/storage/decrease", method = RequestMethod.POST)
    Response decrease(@RequestParam("productId") int productId, @RequestParam("count") int count);
}
