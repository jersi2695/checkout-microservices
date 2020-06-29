package com.hiberus.checkout.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hiberus.commons.entities.order.Order;

@FeignClient(name = "order-service")
public interface IOrderClientRest {
	
	@PostMapping("/api/create")
	public Order create(@RequestBody Order order);
}
