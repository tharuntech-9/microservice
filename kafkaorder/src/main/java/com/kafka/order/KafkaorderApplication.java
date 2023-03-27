package com.kafka.order;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.order.dto.OrderDto;
import com.kafka.order.producer.OrderProducer;

@SpringBootApplication
public class KafkaorderApplication {

	public static void main(String[] args) throws JsonProcessingException {
		ApplicationContext context = SpringApplication.run(KafkaorderApplication.class, args);
		OrderProducer producer = context.getBean(OrderProducer.class);
		
		OrderDto order = new OrderDto();
		order.setOrderNo(1);
		order.setOrderedDate(new Date());
		order.setCustomerNo(2);
		order.setQuantity(19);
		order.setAmount(2000);
		
		producer.createOrder(order);
		System.out.println("order has been created...");

	}

}
