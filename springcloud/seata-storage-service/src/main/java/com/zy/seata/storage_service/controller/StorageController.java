package com.zy.seata.storage_service.controller;

import com.zy.seata.storage_service.domain.Response;
import com.zy.seata.storage_service.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/decrease")
    public Response decrease(int productId, int count) {
        storageService.decrease(productId, count);
        return new Response(200, "库存扣减成功");
    }
}
