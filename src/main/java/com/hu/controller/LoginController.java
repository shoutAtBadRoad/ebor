package com.hu.controller;


import com.hu.model.User;
import com.hu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public String login(@RequestBody User user) {
        String token = loginService.loginReturnToken(user.getUsername(), user.getPassword());
        return token;
    }

    @PostMapping("/user/logout")
    public String logout() {
        return loginService.logtout();
    }
}
