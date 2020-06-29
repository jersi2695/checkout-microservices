package com.hiberus.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.hiberus.commons.entities.order.Order;
import com.hiberus.order.services.IOrderService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api")
@Api(value = "Orders microservice", description = "This API has a CRUD for orders")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;

	@GetMapping("/list")
	public List<Order> list(){
		return orderService.findAll();
	}
	
	@GetMapping("/detail/{id}")
	public Order detail(@PathVariable(name = "id") Long id){
		Order order =  orderService.findById(id).get();
		return order;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Order create(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		orderService.delete(id);
	}
	
	@PatchMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Order edit(@RequestBody Order order, @PathVariable Long id) {
		Order oldOrder = orderService.findById(id).get();
		
		oldOrder.setStatus(order.getStatus());
		return orderService.save(oldOrder);
	}
	
}
