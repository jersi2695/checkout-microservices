package com.hiberus.logistic.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hiberus.commons.entities.logistic.SentOrder;

@RepositoryRestResource()
@Repository
public interface SentOrderDao extends PagingAndSortingRepository<SentOrder, Long>{

}
