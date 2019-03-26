package com.example.invoice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	private long id;

	@Embedded
	private Customer customer;

	private Date updated;

	@Embedded
	private Address address = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<InvoiceLine> invoiceLine;

	public Invoice() {
		super();
		invoiceLine = new ArrayList<InvoiceLine>();
	}

	public Invoice(long id, Customer customer, Date updated, Address address, List<InvoiceLine> invoiceLine) {
		super();
		this.id = id;
		this.customer = customer;
		this.updated = updated;
		this.address = address;
		this.invoiceLine = invoiceLine;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customerId) {
		this.customer = customerId;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date created) {
		this.updated = created;
	}

	public List<InvoiceLine> getInvoiceLine() {
		return invoiceLine;
	}

	public Invoice(Customer customer) {
		super();
		this.customer = customer;
		this.invoiceLine = new ArrayList<InvoiceLine>();
	}

	public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	@Transient
	public void setOrderLine(List<InvoiceLine> orderLine) {
		this.invoiceLine = orderLine;
	}

	public int getNumberOfLines() {
		return invoiceLine.size();
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
