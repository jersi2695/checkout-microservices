package com.hiberus.bill.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hiberus.commons.entities.bill.Bill;

public interface BillDao extends PagingAndSortingRepository<Bill, Long>{

	Bill findByOrderId(long orderId);
}
