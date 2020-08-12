package edu.miu.lelafoods.order.service.impl;

import edu.miu.lelafoods.order.dao.CartDao;
import edu.miu.lelafoods.order.dao.FoodDao;
import edu.miu.lelafoods.order.dao.OrderDao;
import edu.miu.lelafoods.order.domain.*;
import edu.miu.lelafoods.order.dto.CartDto;
import edu.miu.lelafoods.order.domain.Restaurant;
import edu.miu.lelafoods.order.service.CartService;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
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
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject("http://localhost:8080/customers/"+cart.getCustomerId(), Customer.class);
        Restaurant restaurant = restTemplate.getForObject("http://localhost:8083/restaurants/"+cart.getRestaurantId(), Restaurant.class);
        if(customer != null && restaurant != null){
            cart.setOrderDate(new Date());
            cart.setStatus(OrderStatus.NEW.toString());
            cartDao.save(cart);
            rabbitMQSenderService.initializeRabbit();
            CartDto cartDto = new CartDto();
            cartDto.setCustomer(customer);
            cartDto.setRestaurant(restaurant);
            cartDto.setOrder(cart.getOrder());
            cartDto.setId(cart.getId());
            cartDto.setOrderDate(cart.getOrderDate());
            cartDto.setStatus(cart.getStatus());
            rabbitMQSenderService.sendCart(cartDto);
        }
    }

    @Override
    public void addToCart(Long idCart, Long idFood, Integer quantity) {
        Cart cart = cartDao.findOne(idCart);
        Food food = foodDao.findOne(idFood);
        cart.getOrder().add(new Order(quantity, food));
        //cart.setSubtotal(cart.calculateTotal());
        cartDao.update(cart);
//        rabbitMQSenderService.initializeRabbit();
//        rabbitMQSenderService.sendCart(cart);
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

    @Override
    public Cart findById(long id) {
        return cartDao.findOne(id);
    }


         /*Order Order = this.findItemInCart(productCode);

        if (itemInfo != null) {
            this.cartItem.remove(itemInfo);*/

        }


