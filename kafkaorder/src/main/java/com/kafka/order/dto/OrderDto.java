package com.kafka.order.dto;

import java.util.Date;

public class OrderDto {
	private int orderNo;
	private Date orderedDate;
	private int customerNo;
	private int quantity;
	private double amount;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDto [orderNo=" + orderNo + ", orderedDate=" + orderedDate + ", customerNo=" + customerNo
				+ ", quantity=" + quantity + ", amount=" + amount + "]";
	}

}
