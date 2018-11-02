package com.kkl.demo.oauth2.server.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Log4j
public class IndexController {
    @GetMapping("/sayHello")
    private String sayHello(){
        log.info("Hello World");
        return "Hello World";
    }

    @GetMapping("/me")
    public Principal user(Principal user){
        return user;
    }
}
