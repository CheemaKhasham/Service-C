package com.example.servicec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCApplication.class, args);
    }

    @Value("${spring.application.name:ServiceC}")
    private String serviceName;

    @GetMapping("/data")
    public String getSimpleData() {
        return String.format("Data from %s (fast response)", serviceName);
    }

    @GetMapping("/healthz")
    public String healthCheck() {
        return "{\"status\":\"healthy\"}";
    }
}
