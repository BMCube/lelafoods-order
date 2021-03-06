package edu.miu.lelafoods.order.service.impl;

import edu.miu.lelafoods.order.dto.CartDto;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import edu.miu.lelafoods.order.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

       @Override
    public void sendCart(CartDto cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getRoutingkey(), cart);
        System.out.println("Sent cart = " + cart.toString());
    }
}
