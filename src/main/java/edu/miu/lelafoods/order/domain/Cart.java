package edu.miu.lelafoods.order.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id",nullable = false)
    private Long id;

     public Cart(){

     }
    public Cart(Long id, BigDecimal subtotal) {
        this.id =id;

    }

    @Valid
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable ( name="cart_order", joinColumns={@JoinColumn(name="cart_id")},
            inverseJoinColumns={ @JoinColumn(name="order_id", unique=true)} )
    List<Order> order;



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }


    public BigDecimal calculateTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (Order order : this.getOrder()) {
            total.add(BigDecimal.valueOf(order.getFood().getPrice()*(order.getOrderQuantity())));
            System.out.println( "order " + order.getId());
        }
        return total;
    }








}
