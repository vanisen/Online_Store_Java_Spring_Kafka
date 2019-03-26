package com.example.invoice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.example.invoice.model.Product;

@Entity
public class InvoiceLine {

	@Column(name = "count")
	private int count;

	@Embedded
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

	public InvoiceLine() {
	}

	public InvoiceLine(int count, Product product) {
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
