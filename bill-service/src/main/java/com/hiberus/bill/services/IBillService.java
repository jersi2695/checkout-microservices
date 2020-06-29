package com.hiberus.bill.services;

import com.hiberus.bill.exceptions.BillServiceException;
import com.hiberus.commons.entities.bill.Bill;
import com.hiberus.commons.entities.order.Order;

public interface IBillService {
	
	Bill createBill(Order order) throws BillServiceException;
	
	Bill findByOrderId(long id);

}
