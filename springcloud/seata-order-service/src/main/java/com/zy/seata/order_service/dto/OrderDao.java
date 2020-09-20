package com.zy.seata.order_service.dto;

import com.zy.seata.order_service.domain.Order;
import feign.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    /**
     * 新建订单
     * */
    void create(Order order);

    /**
     * 修改订单状态
     * */
    void updateStatus(@Param("userId") int userId, @Param("status") int status);
}
