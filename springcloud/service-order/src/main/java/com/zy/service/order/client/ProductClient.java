package com.zy.service.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service")
@Component
public interface ProductClient {

    @GetMapping("/api/v1/product/find")
    String findById(@RequestParam(value = "id") int id);
}