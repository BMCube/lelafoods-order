package edu.miu.lelafoods.order.service.Impl;

import edu.miu.lelafoods.order.dao.CartDao;
import edu.miu.lelafoods.order.dao.FoodDao;
import edu.miu.lelafoods.order.dao.OrderDao;
import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.CartService;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    FoodDao foodDao;
    @Autowired
    RabbitMQSenderService rabbitMQSenderService;
    @Override
    public void save(Cart cart) {
        cartDao.save(cart);
    }

    @Override
    public void addToCart(Long idCart, Long idFood, Integer quantity) {
        Cart cart = cartDao.findOne(idCart);
        Food food = foodDao.findOne(idFood);
        cart.getOrder().add(new Order(quantity, food));
        cartDao.update(cart);
        rabbitMQSenderService.initializeRabbit();
        rabbitMQSenderService.sendOrder(cart);

    }

    @Override
    public Long ordered(Long idCart) {
        return null;
    }

    @Override
    public List<Cart> findall() {
        return cartDao.findAll();
    }

    @Override
    public void deleteCart(long id) {
        cartDao.deleteById(id);


    }


         /*Order Order = this.findItemInCart(productCode);

        if (itemInfo != null) {
            this.cartItem.remove(itemInfo);*/

        }


