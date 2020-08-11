package edu.miu.lelafoods.order.controller;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CartController.BASE_URL)
public class CartController {

    public static final String BASE_URL = "/orders/carts";

    @Autowired
    CartService cartService;

    @GetMapping("")
    public List<Cart> findAllinCart() {
        List<Cart> foodsList = cartService.findall();
        return foodsList;
    }
    @PostMapping()
    public void CreateCart(@RequestBody Cart cart) {
        cartService.save(cart);
    }

    @RequestMapping(value = "/addTocart/{idCart}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<Void> addOrderToCart(@PathVariable("idCart") Long idCart, @RequestParam("idFood") Long idFood,
                                    @RequestParam("quantity") Integer quantity) {
        cartService.addToCart(idCart, idFood, quantity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
