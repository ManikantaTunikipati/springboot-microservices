package com.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{customerId}")
    public Map<String, Object> getOrder(@PathVariable Long customerId) {

        Map<String, Object> res = new HashMap<>();
        res.put("orderId", 1111);
        res.put("customerId", customerId);
        res.put("amount", 5000);
        res.put("status", "DELIVERED");

        return res;
    }
}

