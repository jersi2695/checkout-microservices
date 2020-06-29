package com.hiberus.checkout.wrapper;

import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.logistic.SentOrder;
import com.hiberus.commons.entities.order.Order;

public class CheckoutWrapper {
	
	private Order order;

	private Bill bill;
	
	private SentOrder sentOrder;
	
	

	public CheckoutWrapper(Order order, Bill bill, SentOrder sentOrder) {
		super();
		this.order = order;
		this.bill = bill;
		this.sentOrder = sentOrder;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public SentOrder getSentOrder() {
		return sentOrder;
	}

	public void setSentOrder(SentOrder sentOrder) {
		this.sentOrder = sentOrder;
	}	

}
