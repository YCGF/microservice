package com.zy.seata.order_service.controller;

import com.zy.seata.order_service.domain.Order;
import com.zy.seata.order_service.domain.Response;
import com.zy.seata.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Response create(Order order) {
        orderService.create(order);
        return new Response(200, "订单创建成功");
    }
}
