package edu.miu.lelafoods.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.lelafoods.order.domain.Food;
import edu.miu.lelafoods.order.domain.Order;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {

    private MockMvc mocMvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    ObjectMapper om = new ObjectMapper();


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mocMvc = MockMvcBuilders
                .standaloneSetup(orderController)
                .build();
    }

    @Test
    public void testList() throws Exception{
        mocMvc.perform(get(OrderController.BASE_URL).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetOrderById() throws Exception{
        Food food = new Food();
        food.setPrice(25.5);
        food.setId(1L);
        food.setName("Doro");
        Order order = new Order(1,food);
        when(orderService.getOrderById(1L)).thenReturn(order);
        mocMvc.perform(get(OrderController.BASE_URL+"/1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.food.id", is(1)))
                .andExpect(jsonPath("$.food.name", is("Doro")))
                .andExpect(jsonPath("$.food.price", is(25.5)))
                .andReturn();
    }
    

}
