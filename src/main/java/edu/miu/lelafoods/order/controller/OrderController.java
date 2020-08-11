package edu.miu.lelafoods.order.controller;

import java.util.List;

import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.OrderService;

@RestController
@RequestMapping(OrderController.BASE_URL)
public class OrderController {

    public static final String BASE_URL = "/orders";

    @Autowired
    private OrderService orderService;

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    @RequestMapping("")
    public List<Order> list() {
        return orderService.getAllOrders();
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)

    public void processAddNewOrderForm(@RequestBody Order orderToBeAdded) {
        rabbitMQSenderService.initializeRabbit();
        rabbitMQSenderService.sendOrder(orderToBeAdded);
        orderService.addOrder(orderToBeAdded);
        return;
    }

}
