package com.microservice.SAPUserService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// a test controller to check if the server is running
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "SAP USER SERVICE SERVER RUNNING!!!";
    }
}
