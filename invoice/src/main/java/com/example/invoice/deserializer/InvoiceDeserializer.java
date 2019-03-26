package com.example.invoice.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.invoice.model.Invoice;

public class InvoiceDeserializer extends JsonDeserializer<Invoice> {

	public InvoiceDeserializer() {
		super(Invoice.class);
	}

}
