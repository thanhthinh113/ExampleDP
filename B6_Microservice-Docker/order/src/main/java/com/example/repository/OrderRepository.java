package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
}