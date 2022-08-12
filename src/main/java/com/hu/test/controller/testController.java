package com.hu.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/hu")
    @PreAuthorize("hasAuthority('system:test:list')")
    public String test() {
        return "success";
    }

    @GetMapping("/failtest")
    @PreAuthorize("hasAuthority('fail')")
    public String failTest() {
        return "fail";
    }
}
