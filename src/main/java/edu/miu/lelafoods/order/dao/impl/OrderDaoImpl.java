package edu.miu.lelafoods.order.dao.impl;

import edu.miu.lelafoods.order.dao.OrderDao;
import edu.miu.lelafoods.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
    public OrderDaoImpl(){
        super.setDaoType(Order.class);
    }
   /* @Override
    public List<Order> showOrdersForToday() {
        return null;
    }*/
}
