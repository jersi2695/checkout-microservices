package com.hiberus.checkout.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.order.Order;

@FeignClient(name = "bill-service")
public interface IBillClientRest {
	
	@PostMapping("/api/generate-bill")
	public Bill create(@RequestBody Order order);
}
