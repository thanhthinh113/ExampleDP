package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;
import com.example.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		// Kiểm tra khách hàng
		ResponseEntity<Object> customerResponse = restTemplate
				.getForEntity("http://api-gateway:8080/customers/" + order.getCustomerId(), Object.class);
		if (!customerResponse.getStatusCode().is2xxSuccessful()) {
			return ResponseEntity.badRequest().build();
		}

		// Kiểm tra sản phẩm và tồn kho
		ResponseEntity<Product> productResponse = restTemplate
				.getForEntity("http://api-gateway:8080/products/" + order.getProductId(), Product.class);
		if (!productResponse.getStatusCode().is2xxSuccessful()
				|| productResponse.getBody().getStock() < order.getQuantity()) {
			return ResponseEntity.badRequest().build();
		}

		// Lưu đơn hàng
		order.setStatus("CREATED");
		Order savedOrder = repository.save(order);

		// Gửi thông điệp Kafka để cập nhật tồn kho
		kafkaTemplate.send("order-created", order.getProductId() + ":" + order.getQuantity());

		return ResponseEntity.ok(savedOrder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable String id) {
		Optional<Order> order = repository.findById(id);
		return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order updatedOrder) {
		Optional<Order> existingOrder = repository.findById(id);
		if (existingOrder.isPresent()) {
			Order order = existingOrder.get();
			order.setStatus(updatedOrder.getStatus());
			return ResponseEntity.ok(repository.save(order));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}

class Product {
	private String id;
	private int stock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}