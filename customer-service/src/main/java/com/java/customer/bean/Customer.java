package com.java.customer.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Customer {

	@NotNull(message = "Customer ID cannot be null")
	@Min(value = 1, message = "Customer ID must be greater than 0")
	int id;

	@NotBlank(message = "Customer name is required")
	String name;

	@Min(value = 18, message = "Age must be at least 18")
	int age;

	private Address address;

	@JsonIgnore
	private String password;

	public Customer(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

}
