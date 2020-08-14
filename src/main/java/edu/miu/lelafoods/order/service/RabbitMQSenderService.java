package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.dto.CartDto;

public interface RabbitMQSenderService {
	public void sendCart(CartDto cart);
}