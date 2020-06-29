package com.hiberus.checkout.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hiberus.commons.entities.logistic.SentOrder;

@FeignClient(name = "logistic-service")
public interface ILogisticClientRest {
	
	@PostMapping("/sentOrders")
	public SentOrder createSentOrder(@RequestBody SentOrder sentOrder);
}
