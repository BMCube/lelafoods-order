package edu.miu.lelafoods.order.dto;

import edu.miu.lelafoods.order.domain.Customer;
import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.domain.Restaurant;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CartDto {

    private Long id;

    private Customer customer;

    private Restaurant restaurant;

    private Date orderDate;

    private String status;

    List<Order> orderList;

    public CartDto() {

    }

    public CartDto(Long id, BigDecimal subtotal) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getOrder() {
        return orderList;
    }

    public void setOrder(List<Order> orderList) {
        this.orderList = orderList;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", orderList=" + orderList +
                '}';
    }
}