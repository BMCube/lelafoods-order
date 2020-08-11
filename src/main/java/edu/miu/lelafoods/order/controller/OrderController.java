package edu.miu.lelafoods.order.controller;

import java.util.List;

import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    @GetMapping("")
    public List<Order> list() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping()
    public void processAddNewOrderForm(@RequestBody Order orderToBeAdded) {
        rabbitMQSenderService.initializeRabbit();
        rabbitMQSenderService.sendOrder(orderToBeAdded);
        orderService.addOrder(orderToBeAdded);
        return;
    }

}
