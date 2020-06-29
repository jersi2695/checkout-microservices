package com.hiberus.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.commons.entities.order.Order;
import com.hiberus.order.dao.OrderDao;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> findAll() {		
		return (List<Order>) orderDao.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderDao.findById(id);
	}

	@Override
	public Order save(Order order) {
		return orderDao.save(order);
	}

	@Override
	public void delete(Long id) {
		orderDao.deleteById(id);
	}

}
