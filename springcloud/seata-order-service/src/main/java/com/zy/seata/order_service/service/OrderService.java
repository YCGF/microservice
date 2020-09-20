package com.zy.seata.order_service.service;

import com.zy.seata.order_service.domain.Order;

public interface OrderService {

    void create(Order order);
}
