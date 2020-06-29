package com.hiberus.commons.entities.logistic;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sent_orders")
public class SentOrder implements Serializable{
	
	private static final int DAYS_DISPATCH = 4;
	private static final long serialVersionUID = -2816196505856099344L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long orderId;
	
	private LocalDate dateCreated = LocalDate.now();
	
	private LocalDate dateDispatch = LocalDate.now().plusDays(DAYS_DISPATCH);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getDateDispatch() {
		return dateDispatch;
	}

	public void setDateDispatch(LocalDate dateDispatch) {
		this.dateDispatch = dateDispatch;
	}	

}
