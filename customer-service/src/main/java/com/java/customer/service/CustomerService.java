package com.java.customer.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.customer.bean.Customer;
import com.java.customer.bean.OrderResponse;
import com.java.order.controller.OrderClient;

@Service
public class CustomerService {

	// In-memory storage instead of database
	// Key = customerId, Value = Customer object
	private Map<Integer, Customer> store = new HashMap<>();

	@Autowired
	private OrderClient orderClient;

	public OrderResponse fetchOrderFromOrderService(Long id) {
		return orderClient.getOrder(id); // Feign makes REST call
	}

	/**
	 * Create or Save a Customer
	 */
	public ResponseEntity<String> createCustomer(Customer customer) {

		// Interview Tip:
		// If DB not available, always check for duplicates manually.
		if (store.containsKey(customer.getId())) {
			return ResponseEntity.badRequest().body("Customer already exists!");
		}

		store.put(customer.getId(), customer); // Save in map
		return ResponseEntity.ok("Customer created successfully!");
	}

	/**
	 * Get a Customer by ID
	 */
	public Customer getCustomerById(Long id) {

		// Check if exists
		Customer customer = store.get(id);
		if (customer == null) {
//			return ResponseEntity.status(404).body("Customer Not Found!");
		}

		return new Customer(1, "raja");
	}

	/**
	 * Update Customer
	 */
	public ResponseEntity<?> updateCustomer(int id, Customer newData) {

		// Check existence
		if (!store.containsKey(id)) {
			return ResponseEntity.status(404).body("Cannot update — Customer Not Found!");
		}

		// Replace old with new
		store.put(id, newData);
		return ResponseEntity.ok("Customer updated successfully!");
	}

	/**
	 * Delete Customer
	 */
	public ResponseEntity<String> deleteCustomer(int id) {

		if (!store.containsKey(id)) {
			return ResponseEntity.status(404).body("Customer Not Found!");
		}

		store.remove(id);
		return ResponseEntity.ok("Customer deleted successfully!");
	}

	/**
	 * Get all customers
	 */
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(new ArrayList<>(store.values()));
	}

	// SEARCH BY NAME (A3)
//    public List<Customer> searchByName(String name) {
//        return store.values()
//                .stream()
//                .filter(c -> c.getName().equalsIgnoreCase(name))
//                .collect(Collectors.toList());
//    }
	public List<Customer> searchByName(String name) {

		return store.values().stream().filter(n -> n.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

	}

	public List<Customer> ageFilter(int age) {

		return store.values().stream().filter(n -> n.getAge() > age).collect(Collectors.toList());
	}

	public List<Customer> sortByName() {
		return store.values().stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList());
	}
}
