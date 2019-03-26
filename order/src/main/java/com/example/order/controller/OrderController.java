package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.model.Order;
import com.example.order.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
	private OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

    @PostMapping("/orders")
    public Order post(@RequestBody Order order) {
        return orderService.order(order);
    }
}
