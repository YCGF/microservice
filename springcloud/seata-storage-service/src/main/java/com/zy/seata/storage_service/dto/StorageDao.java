package com.zy.seata.storage_service.dto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface StorageDao {

    void decrease(@RequestParam("productId") int productId, @RequestParam("count") int count);
}
