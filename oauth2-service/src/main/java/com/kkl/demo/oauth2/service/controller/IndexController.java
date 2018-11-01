package com.kkl.demo.oauth2.service.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class IndexController {
    @GetMapping("/sayHello")
    private String sayHello(){
        log.info("Hello World  -  service");
        return "Hello World  -  service";
    }
}