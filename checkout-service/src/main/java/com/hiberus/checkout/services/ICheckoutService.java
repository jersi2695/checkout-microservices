package com.hiberus.checkout.services;

import com.hiberus.checkout.exception.CheckoutServiceException;
import com.hiberus.checkout.wrapper.CheckoutWrapper;
import com.hiberus.commons.entities.order.Order;

public interface ICheckoutService {
	
	CheckoutWrapper checkoutOrder(Order order) throws CheckoutServiceException;
}
