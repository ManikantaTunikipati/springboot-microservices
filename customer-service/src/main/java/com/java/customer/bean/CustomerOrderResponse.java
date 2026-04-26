package com.java.customer.bean;

public class CustomerOrderResponse {

    private Customer customer;
    private OrderResponse order;

    public CustomerOrderResponse(Customer customer, OrderResponse order) {
        this.customer = customer;
        this.order = order;
    }
}

