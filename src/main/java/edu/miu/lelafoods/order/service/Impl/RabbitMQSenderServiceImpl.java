package edu.miu.lelafoods.order.service.Impl;

import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${lelafoods-order.rabbitmq.exchange}")
    private String exchange;

    @Value("${lelafoods-order.rabbitmq.routingkey}")
    private String routingkey;
    //For now not used
    String amqpTopic = "lelafoods_order_topic";

    @Override
    public void sendOrder(Order order) {
        amqpTemplate.convertAndSend(exchange, routingkey, order);
        System.out.println("Send order = " + order);
    }
}
