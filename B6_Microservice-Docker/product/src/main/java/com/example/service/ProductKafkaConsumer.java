package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductKafkaConsumer {
	@Autowired
	private ProductRepository repository;

	@KafkaListener(topics = "order-created", groupId = "product-group")
	public void updateStock(String message) {
		// Giả sử message chứa "productId:quantity"
		String[] parts = message.split(":");
		String productId = parts[0]; // String thay vì Long
		int quantity = Integer.parseInt(parts[1]);

		Product product = repository.findById(productId).orElseThrow();
		product.setStock(product.getStock() - quantity);
		repository.save(product);
	}
}