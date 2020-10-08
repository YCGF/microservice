package com.zy.service.order.controller;

import com.zy.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RefreshScope // 支持nacos的动态刷新功能
public class OrderController {

    @Autowired
    OrderService orderService;

    @Value("${nacos.config}")
    private String config;

    /**
     * http://localhost:9100/api/v1/order/config
     * */
    @RequestMapping("/config")
    public String config() {
        return config;
    }

    /**
     * http://localhost:9100/api/v1/order/save?user_id=1&product_id=1
     * */
    @RequestMapping("/save")
    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId){
        return orderService.save(userId, productId);
    }

}
