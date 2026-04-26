package com.java.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.customer.bean.OrderResponse;

@FeignClient(name = "order-service")
public interface OrderClient {

	@GetMapping("/orders/{customerId}")
	OrderResponse getOrder(@PathVariable("customerId") Long customerId);
}
