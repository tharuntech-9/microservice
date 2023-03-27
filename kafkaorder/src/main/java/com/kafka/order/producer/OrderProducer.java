package com.kafka.order.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.order.dto.OrderDto;

@Component
public class OrderProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void createOrder(OrderDto order) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String value = objectMapper.writeValueAsString(order);
		
		kafkaTemplate.send("ordertopic", String.valueOf(order.getOrderNo()), value);
	}
}
