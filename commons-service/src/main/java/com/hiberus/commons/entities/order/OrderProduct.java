package com.hiberus.commons.entities.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProduct implements Serializable {

	private static final long serialVersionUID = 2985530328229392023L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderProductId;

	private long id;
		
	private long quantity;
	
	private double cost;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	
	
}
