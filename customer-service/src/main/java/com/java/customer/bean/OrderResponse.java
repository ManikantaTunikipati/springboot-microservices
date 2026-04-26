package com.java.customer.bean;

public class OrderResponse {
	private Long orderId;
	private Long customerId;
	private double amount;
	private String status;

	public OrderResponse(long orderId, Long customerId, int amount, String status) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.amount = amount;
		this.status = status;

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", customerId=" + customerId + ", amount=" + amount + ", status="
				+ status + "]";
	}

}
