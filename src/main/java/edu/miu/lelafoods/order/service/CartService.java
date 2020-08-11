package edu.miu.lelafoods.order.service;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Food;

import java.util.List;

public interface CartService {

    void save(Cart cart);
    void addToCart(Long idCart, Long idFood, Integer quantity);
    Long ordered(Long idCart);
    List<Cart> findall();
    void deleteCart(long id);

}
