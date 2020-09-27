package com.zy.service.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zy.service.product.model.Product;
import com.zy.service.product.model.Response;
import com.zy.service.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

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
        log.info(Thread.currentThread().getName());
        return productService.findAll();
    }

    @RequestMapping("/find")
//    @SentinelResource(value = "find")
    @SentinelResource(value = "find", fallback = "")
//    @SentinelResource(value = "find", blockHandler = "")
//    @SentinelResource(value = "find", fallback = "", blockHandler = "")
//    @SentinelResource(value = "", exceptionsToIgnore = {})
    public Product findById(@RequestParam("id") int id){
        if (id == 2) {
            throw new IllegalArgumentException("/api/v1/product/find IllegalArgumentException");
        }
        if (id > 10) {
            throw new NullPointerException("/api/v1/product/find NullPointerException");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productService.findById(id), product);
        product.setName(product.getName() + ", data from port = " + port);
        return product;
    }

    public Response fallback(@PathVariable int id, Throwable e) {
        Product product = new Product(id, null, 0);
        return new Response(500, "[fallback] => " + product.toString() + ". Exception => " + e.getMessage());
    }

    public Response blockHandler(@PathVariable int id, BlockException e) {
        Product product = new Product(id, null, 0);
        return new Response(500, "[blockHandler] => " + product.toString() + ". Exception => " + e.getMessage());
    }

}
