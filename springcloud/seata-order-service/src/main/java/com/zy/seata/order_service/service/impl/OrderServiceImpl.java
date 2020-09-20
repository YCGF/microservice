package com.zy.seata.order_service.service.impl;

import com.zy.seata.order_service.domain.Order;
import com.zy.seata.order_service.dto.OrderDao;
import com.zy.seata.order_service.service.AccountService;
import com.zy.seata.order_service.service.OrderService;
import com.zy.seata.order_service.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
//    @GlobalTransactional(name = "seata-order-create", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("开始创建订单");
        orderDao.create(order);

        log.info("订单服务开始调用库存服务，减少库存 Start");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("订单服务开始调用库存服务，减少库存 End");

        log.info("订单服务开始调用账户服务，扣钱 Start");
        accountService.decrease(order.getUserId(), order.getPrice());
        log.info("订单服务开始调用账户服务，扣钱 End");

        log.info("订修改订单状态 Start");
        orderDao.updateStatus(order.getUserId(), 0);
        log.info("订修改订单状态 End");

        log.info("订单结束");
    }
}
