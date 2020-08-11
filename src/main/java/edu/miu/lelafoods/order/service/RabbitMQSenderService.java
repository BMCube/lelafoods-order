package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Order;

public interface RabbitMQSenderService {
	public void sendCart(Cart cart);
	public void initializeRabbit();
}