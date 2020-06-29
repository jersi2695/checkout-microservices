package com.hiberus.bill.exceptions;

public class BillServiceException extends Exception{

	private static final long serialVersionUID = 7628904850295106428L;
	
	private long orderId;
	
	public BillServiceException(String errorMessage, long orderId) {
		super(errorMessage);
		this.setOrderId(orderId);
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

}
