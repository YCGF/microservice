package com.zy.service.product.service.impl;

import com.zy.service.product.model.Product;
import com.zy.service.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer,Product> productDao = new HashMap();

    static {
        Product p1 = new Product(1, "iPhoneX", 9999);
        Product p2 = new Product(2, "冰箱", 5342);
        Product p3 = new Product(3, "洗衣机", 523);
        Product p4 = new Product(4, "电话", 64345);
        Product p5 = new Product(5, "汽车", 2345);
        Product p6 = new Product(6, "椅子", 253);
        Product p7 = new Product(7, "java编程思想", 2341);

        productDao.put(p1.getId(),p1);
        productDao.put(p2.getId(),p2);
        productDao.put(p3.getId(),p3);
        productDao.put(p4.getId(),p4);
        productDao.put(p5.getId(),p5);
        productDao.put(p6.getId(),p6);
        productDao.put(p7.getId(),p7);
    }

    @Override
    public List<Product> findAll() {
        Collection<Product> collection = productDao.values();
        return new ArrayList<>(collection);
    }

    @Override
    public Product findById(int id) {
        return productDao.get(id);
    }
}
