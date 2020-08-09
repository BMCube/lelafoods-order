package edu.miu.lelafoods.order.service.Impl;

import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import edu.miu.lelafoods.order.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private ApplicationProperties applicationProperties;

    //For now not used
    String amqpTopic = "lelafoods_order_topic";

    @Override
    public void sendOrder(Order order) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getRoutingkey(), order);
        System.out.println("Send order = " + order);
    }
}
