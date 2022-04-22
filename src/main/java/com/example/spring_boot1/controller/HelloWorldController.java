package com.example.spring_boot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/index")
    public String sayHello(){
        return "Hello www";
    }
}
