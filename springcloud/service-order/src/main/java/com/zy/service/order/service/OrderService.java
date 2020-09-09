package com.zy.service.order.service;

import com.zy.service.order.model.Order;

public interface OrderService {

    /**
     * 下单接口
     *
     * @param userId User ID
     * @param productId Product ID
     * @return Order
     */
    Order save(int userId, int productId);
}
