package com.zy.service.product.service;

import com.zy.service.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int id);
}
