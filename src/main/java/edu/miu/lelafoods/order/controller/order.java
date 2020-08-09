package edu.miu.lelafoods.order.controller;


import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.OrderService;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class order {
    @Autowired
    OrderService orderService;

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    @PostMapping(value = "/add")
    public void producer(@RequestBody Order order) {
        orderService.addOrder(order);
        rabbitMQSenderService.sendOrder(order);
        return;
    }


}
