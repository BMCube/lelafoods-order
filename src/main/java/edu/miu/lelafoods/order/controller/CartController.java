package edu.miu.lelafoods.order.controller;

import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(CartController.BASE_URL)
public class CartController {

    public static final String BASE_URL = "/carts";

    @Autowired
    CartService cartService;

    @GetMapping("")
    public List<Cart> findAllinCart() {
        List<Cart> foodsList = cartService.findall();
        return foodsList;
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Void> CreateCart(@RequestBody Cart cart, HttpServletRequest request) {

        cartService.save(cart);
        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    }

    @PutMapping("/{idCart}/order")
    public @ResponseBody
    ResponseEntity<Void> addOrderToCart(@PathVariable("idCart") Long idCart, @RequestParam(value = "idFood") Long idFood,
                                        @RequestParam("quantity") Integer quantity) {
        cartService.addToCart(idCart, idFood, quantity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Cart findByCarId(@PathVariable("id") Long id) {
        return cartService.findById(id);
    }

}
