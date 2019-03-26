package com.example.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.example.order.model.Product;

@Entity
public class OrderLine {

	@Column(name = "count")
	private int count;

	@ManyToOne
	private Product product;

	@Id
	@GeneratedValue
	private long id;

	public void setCount(int count) {
		this.count = count;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderLine() {
	}

	public OrderLine(int count, Product product) {
		this.count = count;
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
