package com.example.order.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.order.model.Order;

@RepositoryRestResource(collectionResourceRel = "orders", path = "order")
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
