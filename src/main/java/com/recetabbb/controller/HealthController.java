package com.recetabbb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
    @author carlossalazar
**/
@RestController
public class HealthController {
    @GetMapping("/api/health")
    public String hello() {
        return "Recetabbb API is up";
    }
}
