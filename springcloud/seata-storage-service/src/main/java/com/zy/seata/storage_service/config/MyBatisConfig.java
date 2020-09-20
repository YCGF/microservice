package com.zy.seata.storage_service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zy.seata.order_service.dto"})
public class MyBatisConfig {

}
