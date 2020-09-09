package com.zy.service.product.controller;

import com.zy.service.product.model.Product;
import com.zy.service.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    /**
     * 获取所有商品列表
     *
     * @return List<Product>
     */
    @RequestMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping("/find")
    public Product findById(@RequestParam("id") int id){
        Product product = new Product();
        BeanUtils.copyProperties(productService.findById(id), product);
        product.setName(product.getName() + ", data from port = " + port);
        return product;
    }
}
