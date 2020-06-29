package com.hiberus.order.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.hiberus.commons.entities.order.Order;

public interface OrderDao extends PagingAndSortingRepository<Order, Long>{

}
