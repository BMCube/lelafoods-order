package edu.miu.lelafoods.order.service.impl;

import edu.miu.lelafoods.order.dao.OrderDao;
import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderDao.findOne(orderId);
    }

    @Override
    public void addOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    public void editOrder(Order editedOrder) {
        orderDao.update(editedOrder);
    }

    @Override
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderDao.deleteById(orderId);
    }
}
