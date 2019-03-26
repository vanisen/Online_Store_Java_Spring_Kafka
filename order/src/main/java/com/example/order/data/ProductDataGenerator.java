package com.example.order.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.order.model.Product;
import com.example.order.repository.ProductRepository;

@Component
public class ProductDataGenerator {

	private final ProductRepository productRepository;

	@Autowired
	public ProductDataGenerator(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostConstruct
	public void generateTestData() {
		productRepository.save(new Product("MacBook Air", 1999.0));
		productRepository.save(new Product("MacBook Pro", 2999.0));
	}

}
