package edu.miu.lelafoods.order.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

    @Column(name = "order_quantity")
    private Integer orderAmount ;
    public Integer getOrderAmount() {
        return orderAmount;
    }
    public Order(){}

    public Order(Integer orderAmount,Food food) {
        this.orderAmount = orderAmount;
        this.food=food;
    }
    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
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
                ", orderAmount=" + orderAmount +
                '}';
    }
}
