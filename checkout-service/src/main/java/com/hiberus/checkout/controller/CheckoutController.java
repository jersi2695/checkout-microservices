package com.hiberus.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.checkout.exception.CheckoutServiceException;
import com.hiberus.checkout.services.ICheckoutService;
import com.hiberus.checkout.wrapper.CheckoutWrapper;
import com.hiberus.commons.entities.order.Order;

@RestController
@RequestMapping("api")
public class CheckoutController {

	@Autowired
	private ICheckoutService checkoutService;
	
	@PostMapping(path = "/checkoutOrder")
	public ResponseEntity<CheckoutWrapper> checkoutOrder(@RequestBody Order order){
		try {
			return ResponseEntity.ok(checkoutService.checkoutOrder(order));
		}catch (CheckoutServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
