package com.java.customer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.java.customer.bean.Customer;

@org.springframework.stereotype.Service
public class Service {

	public ResponseEntity<String> customerValidation(Customer customer) {
		System.out.println("Customer receied to validate customer process");
		System.out.println("validation started");

		if (customer.getName() != null) {
			System.out.println("customer.getName() is not null");
			System.out.println("customer.getName() ::" + customer.getName());
			if (customer.getName().equalsIgnoreCase("Manikanta")) {
				System.out.println("customer is ::"+ "Manikanta");
//				return ResponseEntity.status(200).body("Customer is valid");
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Invalid Login");
			}

		} else {
			System.out.println("Name is null");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("User validation failed");

	}
}
