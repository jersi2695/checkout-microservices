package com.hiberus.checkout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.checkout.clients.IBillClientRest;
import com.hiberus.checkout.clients.ILogisticClientRest;
import com.hiberus.checkout.clients.IOrderClientRest;
import com.hiberus.checkout.exception.CheckoutServiceException;
import com.hiberus.checkout.wrapper.CheckoutWrapper;
import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.logistic.SentOrder;
import com.hiberus.commons.entities.order.Order;

@Service
public class CheckoutService implements ICheckoutService{

	@Autowired
	private IOrderClientRest orderClient;
	
	@Autowired
	private IBillClientRest billClient;
	
	@Autowired
	private ILogisticClientRest logisticClient;
	
	@Override
	public CheckoutWrapper checkoutOrder(Order order) throws CheckoutServiceException {
		try {
			order = orderClient.create(order);
			Bill bill = billClient.create(order);
			SentOrder sentOrder = new SentOrder();
			sentOrder.setOrderId(order.getId());
			sentOrder = logisticClient.createSentOrder(sentOrder);
			
			return new CheckoutWrapper(order, bill, sentOrder);
			
		}catch (Exception e) {
			throw new CheckoutServiceException(e.getMessage(), order);
		}
	}
	
	

}
