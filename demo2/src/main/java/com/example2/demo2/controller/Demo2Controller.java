package com.example2.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo2")
public class Demo2Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! from Demo2";
    }

    @GetMapping("/info")
    public String info() {
        return "This is the Demo Controller";
    }

    @PostMapping("/echo")
    public String echo(String message) {
        return "Echo: " + message;
    }
}
