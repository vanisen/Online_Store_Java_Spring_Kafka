package com.example.shipment.model;

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
@Table(name = "shipments")
public class Shipment {

	@Id
	private long id;

	@Embedded
	private Customer customer;

	private Date updated;

	@Embedded
	private Address address = new Address();

	@OneToMany(cascade = CascadeType.ALL)
	private List<ShipmentLine> shipmentLine;

	public Shipment() {
		super();
		shipmentLine = new ArrayList<ShipmentLine>();
	}

	public Shipment(long id, Customer customer, Date updated, Address address, List<ShipmentLine> shipmentLine) {
		super();
		this.id = id;
		this.customer = customer;
		this.updated = updated;
		this.address = address;
		this.shipmentLine = shipmentLine;
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

	public List<ShipmentLine> getShipmentLine() {
		return shipmentLine;
	}

	public Shipment(Customer customer) {
		super();
		this.customer = customer;
		this.shipmentLine = new ArrayList<ShipmentLine>();
	}

	public void setShipmentLine(List<ShipmentLine> shipmentLine) {
		this.shipmentLine = shipmentLine;
	}

	@Transient
	public void setOrderLine(List<ShipmentLine> orderLine) {
		this.shipmentLine = orderLine;
	}

	public int getNumberOfLines() {
		return shipmentLine.size();
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
