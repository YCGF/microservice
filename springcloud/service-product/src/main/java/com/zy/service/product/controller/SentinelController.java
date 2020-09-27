package com.zy.service.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zy.service.product.handler.CustomBlockHandler;
import com.zy.service.product.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class SentinelController {

    private static Logger log = LoggerFactory.getLogger(SentinelController.class);

    @RequestMapping("/test1")
    public String test1() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("---测试熔断降级---");*/

        int temp = 10 / 0;
        return "test1";
    }

    @RequestMapping(value = "/test/paramFlowRule")
    @SentinelResource(value = "test/paramFlowRule", blockHandler = "testParamFlowRule_handler")
    public String testParamFlowRule(@RequestParam(value = "param1", required = false) String param1,
                                    @RequestParam(value = "param2", required = false) String param2) {
        return "Test ParamFlowRule";
    }

    public String testParamFlowRule_handler(String param1, String param2, BlockException e) {
        return "Test ParamFlowRule Handler";
    }

    @RequestMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "exceptionHandler")
    public Response byResource() {
        return new Response(200, "按资源名称限流测试成功");
    }

    public Response exceptionHandler(BlockException e) {
        return new Response(500, e.getClass().getCanonicalName() + " 服务不可用");
    }

    @RequestMapping(value = "/byUrl")
    @SentinelResource(value = "byUrl")
    public Response byUrl() {
        return new Response(200, "按url限流测试成功");
    }

    @RequestMapping(value = "/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomBlockHandler.class, blockHandler = "exceptionHandler2")
    public Response customerBlockHandler() {
        return new Response(200, "自定义异常处理测试成功");
    }
}
