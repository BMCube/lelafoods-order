package edu.miu.lelafoods.order.utils;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationProperties {

    @Value("${lelafoods-order.rabbitmq.queue}")
    String queueName;

    @Value("${lelafoods-order.rabbitmq.exchange}")
    String exchange;

    @Value("${lelafoods-order.rabbitmq.routingkey}")
    private String routingkey;

    public String getRoutingkey() {
        return routingkey;
    }

    public String getExchange() {
        return exchange;
    }

    public String getQueueName() {
        return queueName;
    }

}
