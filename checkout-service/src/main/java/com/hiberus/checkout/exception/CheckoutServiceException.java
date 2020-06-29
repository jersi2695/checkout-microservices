package com.hiberus.checkout.exception;

import com.hiberus.commons.entities.order.Order;

public class CheckoutServiceException extends Exception {
	
	private static final long serialVersionUID = 9171781663495659633L;
	
	private Order order;
	
	public CheckoutServiceException(String errorMessage, Order order) {
		super(errorMessage);
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}
	

}
