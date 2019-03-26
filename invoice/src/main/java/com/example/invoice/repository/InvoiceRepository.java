package com.example.invoice.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.invoice.model.Invoice;

@RepositoryRestResource(collectionResourceRel = "invoices", path = "invoice")
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {

	@Query("SELECT max(s.updated) FROM Invoice s")
	Date lastUpdate();

}
