package edu.miu.lelafoods.order.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "foodorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Valid
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "foodId")
    Food food;

    @Min(value = 1, message = "Min.size.validation")
    @Column(name = "order_quantity")
    private Integer orderQuantity;

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public Order() {
    }

    public Order(Integer orderQuantity, Food food) {
        this.orderQuantity = orderQuantity;
        this.food = food;
    }

    public void setOrderQuantity(Integer orderAmount) {
        this.orderQuantity = orderAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", food=" + food +
                ", orderQuantity=" + orderQuantity +
                '}';
    }
}