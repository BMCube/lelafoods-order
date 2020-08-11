package edu.miu.lelafoods.order.service.Impl;

import edu.miu.lelafoods.order.domain.Cart;
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
    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Override
    public void initializeRabbit(){
        Queue queue = new Queue(applicationProperties.getQueueName() , true, false, false);
        Binding binding = new Binding(applicationProperties.getQueueName() , Binding.DestinationType.QUEUE, applicationProperties.getExchange(), applicationProperties.getRoutingkey(), null);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(binding);
    }


    @Override
    public void sendCart(Cart cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getRoutingkey(), cart);
        System.out.println("Sent card = " + cart.toString());
    }
}
