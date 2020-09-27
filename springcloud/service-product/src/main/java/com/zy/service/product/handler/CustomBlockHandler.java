package com.zy.service.product.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zy.service.product.model.Response;

public class CustomBlockHandler {

    public static Response exceptionHandler(BlockException e) {
        return new Response(500, "Global Exception Handler");
    }

    public static Response exceptionHandler2(BlockException e) {
        return new Response(500, "Global Exception Handler2");
    }
}
