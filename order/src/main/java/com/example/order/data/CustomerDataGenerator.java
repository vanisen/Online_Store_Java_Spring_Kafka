package com.example.order.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.order.model.Customer;
import com.example.order.repository.CustomerRepository;

@Component
public class CustomerDataGenerator {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerDataGenerator(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@PostConstruct
	public void generateTestData() {
		customerRepository.save(new Customer("Steve Payne", "steve.payne@example.com"));
		customerRepository.save(new Customer("Steve Pittard", "steve.pittard@example.com"));
	}

}
