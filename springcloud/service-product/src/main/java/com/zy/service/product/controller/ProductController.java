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
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RefreshScope // 支持nacos的动态刷新功能
@Slf4j
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @Value("${nacos.config}")
    private String config;

    /**
     * http://localhost:9000/api/v1/product/config
     */
    @RequestMapping("/config")
    public String config() {
        return config;
    }

    /**
     * 获取所有商品列表
     *
     * http://localhost:9000/api/v1/product/findAll
     */
    @RequestMapping("/findAll")
    public List<Product> findAll(){
        log.info(Thread.currentThread().getName());
        return productService.findAll();
    }

    /**
     * http://localhost:9000/api/v1/product/find?id=1
     * */
    @RequestMapping("/find")
    @SentinelResource(value = "find")
//    @SentinelResource(value = "find", fallback = "fallback")
//    @SentinelResource(value = "find", blockHandler = "blockHandler")
//    @SentinelResource(value = "find", fallback = "fallback", blockHandler = "blockHandler")
//    @SentinelResource(value = "find", exceptionsToIgnore = {IllegalArgumentException.class})
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
