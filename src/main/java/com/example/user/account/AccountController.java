package com.example.user.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class AccountController {

    @RequestMapping("/account/{:id}")
    String account(String id) {
        return id;
    }

}
