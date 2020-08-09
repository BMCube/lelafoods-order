package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Order;

public interface RabbitMQSenderService {
	public void sendOrder(Order order);
}