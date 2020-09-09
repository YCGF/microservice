package com.zy.service.order.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.zy.service.order.client.ProductClient;
import com.zy.service.order.model.Order;
import com.zy.service.order.service.OrderService;
import com.zy.service.order.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductClient productClient;

    @Override
    public Order save(int userId, int productId) {
        String response = productClient.findById(productId);
        System.out.println(response);
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setOrderNo(UUID.randomUUID().toString());
        order.setProductName(jsonNode.get("name").toString());
        order.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return order;
    }
}
