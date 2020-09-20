package com.zy.seata.account_service.service;

public interface AccountService {

    void decrease(int userId, double price);
}
