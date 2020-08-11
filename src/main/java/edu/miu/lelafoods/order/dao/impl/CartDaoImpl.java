package edu.miu.lelafoods.order.dao.impl;

import edu.miu.lelafoods.order.dao.CartDao;
import edu.miu.lelafoods.order.dao.OrderDao;
import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Order;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao {
    public CartDaoImpl(){
        super.setDaoType(Cart.class);
    }

}
