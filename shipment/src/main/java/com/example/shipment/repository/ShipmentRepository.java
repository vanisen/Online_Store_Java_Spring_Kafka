package com.example.shipment.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shipment.model.Shipment;

@RepositoryRestResource(collectionResourceRel = "shipments", path = "shipment")
public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {

	@Query("SELECT max(s.updated) FROM Shipment s")
	Date lastUpdate();

}
