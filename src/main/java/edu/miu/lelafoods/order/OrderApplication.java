package edu.miu.lelafoods.order;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.domain.OrderStatus;
import edu.miu.lelafoods.order.service.CartService;
import edu.miu.lelafoods.order.service.FoodService;
import edu.miu.lelafoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class OrderApplication implements CommandLineRunner {

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    public static void main(String[] args) {
        SpringApplication.run(
                OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Food food = new Food("Firfir",Double.valueOf(20),"A shredded flat bread, spiced clarified butter, and the hot spice berbere");
        foodService.save(food);
        Order order = new Order(3,food);
        orderService.addOrder(order);
        Cart cart = new Cart(2L,1L,new Date(), OrderStatus.NEW.toString(),new ArrayList<>(Arrays.asList(order)));
        cartService.save(cart);

    }

}
