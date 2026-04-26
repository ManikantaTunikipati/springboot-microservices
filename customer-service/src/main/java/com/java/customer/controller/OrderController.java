package com.java.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.customer.bean.OrderResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {

	 @GetMapping("/{customerId}")
	    public OrderResponse getOrder(@PathVariable Long customerId) {
	        return new OrderResponse(2001L, customerId, 3500, "DELIVERED");
	    }
	
}
