package com.java.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.customer.bean.Address;
import com.java.customer.bean.Customer;
import com.java.customer.bean.CustomerOrderResponse;
import com.java.customer.bean.OrderResponse;
import com.java.customer.service.CustomerService;
import com.java.order.controller.OrderClient;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private OrderClient orderClient;
//    
	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;

	}

//	public CustomerOrderResponse getCustomerWithOrder(Long id) {
//
//		ResponseEntity<?> customer = getById(id); // database call
//
//		OrderResponse order = orderClient.getOrder(id); // Feign REST call
//
//		return new CustomerOrderResponse(customer, order);
//	}

	@GetMapping("/customer-with-order/{id}")
	public ResponseEntity<OrderResponse> getCustomerOrder(@PathVariable Long id) {
		return ResponseEntity.ok(service.fetchOrderFromOrderService(id));
	}

	// ---------------- CREATE -----------------
	@PostMapping("/create")
	public ResponseEntity<String> create(@Valid @RequestBody Customer customer) {

		// Interview Tip:
		// Always validate required fields in request body.
		if (customer.getName() == null || customer.getName().isEmpty()) {
			return ResponseEntity.badRequest().body("Customer name cannot be empty");
		}

		return service.createCustomer(customer);
	}

	// ---------------- READ -----------------
	@GetMapping("/{id}")
	public Customer getById(@PathVariable Long id) {
		return service.getCustomerById(id);
	}

	// ---------------- READ ALL -----------------
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAll() {
		return service.getAllCustomers();
	}

	// ---------------- UPDATE -----------------
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Customer customer) {
		return service.updateCustomer(id, customer);
	}

	// ---------------- DELETE -----------------
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return service.deleteCustomer(id);
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String name) {

		List<Customer> result = service.searchByName(name);

		// Custom ResponseEntity message
		if (result.isEmpty()) {
			return ResponseEntity.status(404).body("No customer found with name: " + name);
		}

		return ResponseEntity.ok(result);
	}

	public Customer getNestedExample() {

		Address addr = new Address("Madhapur", "Hyderabad", "500081");

		Customer c = new Customer(0, null);
//		    c.setId(1L);
		c.setName("Manikanta");
		c.setAge(27);
		c.setAddress(addr);

		return c;
	}

	@GetMapping("/secure-data")
	public ResponseEntity<String> getSecureData(@RequestHeader("Authorization") String authHeader) {

		return ResponseEntity.ok("Token received: " + authHeader);
	}

}
