package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Order;

import java.util.List;

public interface OrderService {

      List<Order> getAllOrder();
      Order getOrderById(Long orderId);
      void addOrder(Order order);
      void editOrder(Order order);
      void deleteOrderById(Long orderId);





}
