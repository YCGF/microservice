package com.zy.seata.account_service.dto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AccountDao {

    void decrease(@RequestParam("userId") int userId, @RequestParam("price") double price);
}
