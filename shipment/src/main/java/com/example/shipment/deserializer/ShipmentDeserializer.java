package com.example.shipment.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.shipment.model.Shipment;

public class ShipmentDeserializer extends JsonDeserializer<Shipment> {

	public ShipmentDeserializer() {
		super(Shipment.class);
	}

}
