package com.zy.seata.account_service.controller;

import com.zy.seata.account_service.domain.Response;
import com.zy.seata.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/decrease")
    public Response decrease(int userId, double price) {
        accountService.decrease(userId, price);
        return new Response(200, "账户扣钱成功");
    }
}
