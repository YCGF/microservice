package com.zy.seata.account_service.service.impl;

import com.zy.seata.account_service.dto.AccountDao;
import com.zy.seata.account_service.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    private static Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(int userId, double price) {
        log.info("账户服务：扣钱 Start");

        // 模拟超时异常，全局事务回滚
        /*try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        accountDao.decrease(userId, price);
        log.info("账户服务：扣钱 End");
    }
}
