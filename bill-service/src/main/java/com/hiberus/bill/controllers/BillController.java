package com.hiberus.bill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.bill.services.IBillService;
import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.order.Order;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api")
@Api(value = "Bill microservice", description = "This API generate a bill for an order")
public class BillController {
	
	@Autowired
	private IBillService billService;
	
	@PostMapping("/generate-bill")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Bill> create(@RequestBody Order order) {
		try {
			return ResponseEntity.ok(billService.createBill(order)) ;
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	}
	
	@GetMapping("/billByOrderId/{id}")
	public ResponseEntity<Bill> detail(@PathVariable(name = "id") Long id){
		try {
			Bill bill =  billService.findByOrderId(id);
			if(bill != null) {
				return ResponseEntity.ok(bill);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}		
	}
	

}
