package com.hiberus.bill.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.bill.dao.BillDao;
import com.hiberus.bill.exceptions.BillServiceException;
import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.order.Order;

@Service
public class BillService implements IBillService {
	
	@Autowired
	private BillDao billDao;

	@Override
	public Bill createBill(Order order) throws BillServiceException{
		try {
			double total = order.getProducts().stream().map(x -> x.getCost() * x.getQuantity()).reduce(0.0, Double::sum);
			
			Bill bill = new Bill();
			bill.setOrderId(order.getId());
			bill.setTotal(total);
					
			return billDao.save(bill);
		}catch (Exception e) {
			throw new BillServiceException(e.getMessage(), order != null ? order.getId() : 0);
		}
	}
	
	public Bill findByOrderId(long orderId) {
		return billDao.findByOrderId(orderId);
	};

}
