package com.zy.seata.storage_service.service;

public interface StorageService {

    void decrease(int productId, int count);
}
