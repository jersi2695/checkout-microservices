package com.hiberus.order.services;

import java.util.List;
import java.util.Optional;

import com.hiberus.commons.entities.order.Order;

public interface IOrderService {

	List<Order> findAll();
	
	Optional<Order> findById(Long id);
	
	Order save(Order order);
	
	void delete(Long id);
}
