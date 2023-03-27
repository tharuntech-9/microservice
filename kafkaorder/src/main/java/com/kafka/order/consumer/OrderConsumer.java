package com.kafka.order.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	@KafkaListener(topics = { "ordertopic" }, groupId = "ordergroup", autoStartup = "true")
	public void consumeOrders(String orderMessage) {
		System.out.println(orderMessage);
	}
}
