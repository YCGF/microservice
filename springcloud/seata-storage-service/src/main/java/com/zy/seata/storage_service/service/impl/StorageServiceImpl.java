package com.zy.seata.storage_service.service.impl;

import com.zy.seata.storage_service.dto.StorageDao;
import com.zy.seata.storage_service.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    private static Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(int productId, int count) {
        log.info("库存服务：减库存 Start");

        // 模拟超时异常，全局事务回滚
        /*try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        storageDao.decrease(productId, count);
        log.info("库存服务：减库存 End");
    }
}
