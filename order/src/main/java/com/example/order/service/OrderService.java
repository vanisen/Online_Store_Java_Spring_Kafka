package com.example.order.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	private KafkaTemplate<String, Order> kafkaTemplate;

	@Autowired
	private OrderService(OrderRepository orderRepository, KafkaTemplate<String, Order> kafkaTemplate) {
		super();
		this.orderRepository = orderRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public Order order(Order order) {
		Order result = orderRepository.save(order);
		fireOrderCreatedEvent(order);
		return result;
	}

	private void fireOrderCreatedEvent(Order order) {
		kafkaTemplate.send("order", order.getId() + "created", order);
	}

}
