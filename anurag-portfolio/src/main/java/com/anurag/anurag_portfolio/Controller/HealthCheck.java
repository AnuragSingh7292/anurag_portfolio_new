package com.anurag.anurag_portfolio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheck {

    @GetMapping
    public String HealthCheck() {
        return "OK";
    }
}
