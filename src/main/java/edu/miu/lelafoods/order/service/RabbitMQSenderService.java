package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Order;

public interface RabbitMQSenderService {
	public void sendOrder(Cart cart);
	public void initializeRabbit();
}