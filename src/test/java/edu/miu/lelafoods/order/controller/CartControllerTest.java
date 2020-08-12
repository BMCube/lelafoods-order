package edu.miu.lelafoods.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.lelafoods.order.domain.Cart;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.domain.OrderStatus;
import edu.miu.lelafoods.order.service.CartService;
import edu.miu.lelafoods.order.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    ObjectMapper om = new ObjectMapper();

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(cartController)
                .build();
    }

    @Test
    public void testFindAllinCart() throws Exception{
        mockMvc.perform(get(CartController.BASE_URL).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

  /*  @Test
    public void testAddOrdertoCart() throws Exception{
        Food myFood = new Food();
        myFood.setName("Pasta");
        myFood.setPrice(20.0);
        myFood.setId(1L);
        Cart cart = new Cart();
        cart.setId(1L);
        Order order = new Order();
        order.setId(1L);
        order.setOrderAmount(2);
        order.setFood(myFood);

        String jsonRequest = om.writeValueAsString(myFood.getId(),cart.getId(),order.getOrderAmount());
        when(cartService.addToCart(1l, 1l,2)).thenReturn();
        mockMvc.perform(put(CartController.BASE_URL+"/addTocart/1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals(content, jsonRequest);


    }*/


   /* @Test
    public void testCreateCart() throws Exception{
        Food food = new Food();
        food.setId(1L);
        food.setPrice(13.5);
        food.setName("Tofu");
        Order myOrder = new Order();
        myOrder.setId(1L);
        Date myDate = new Date();
        myOrder.setOrderedDate(myDate);
        myOrder.setOrderQuantity(3);
        myOrder.setFood(food);
        myOrder.setStatus(OrderStatus.NEW.toString());
        List<Order> order = new ArrayList<>();
        order.add(myOrder);
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setOrder(order);
        System.out.println(cart.getOrder().get(0).getOrderQuantity());

        String inputJson = om.writeValueAsString(cart);
        //when(cartService.save(cart)).thenReturn(cart);
        MvcResult result = mockMvc.perform(post(CartController.BASE_URL)
        .content(inputJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))

                .andReturn();
     String content = result.getResponse().getContentAsString();
     assertEquals(content, inputJson);


    }*/



}
