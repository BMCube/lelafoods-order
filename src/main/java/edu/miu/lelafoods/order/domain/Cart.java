package edu.miu.lelafoods.order.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id", nullable = false)
    private Long id;

    private Long customerId;

    private Long restaurantId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "orders", length = 19)
    private Date orderDate;

    @Column(name = "status", length = 20)
    private String status;

    @Valid
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "cart_order", joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", unique = true)})
    List<Order> orderList;

    public Cart() {

    }

    public Cart(Long customerId, Long restaurantId, Date orderDate, String status) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Cart(Long customerId, Long restaurantId, Date orderDate, String status, @Valid List<Order> orderList) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderDate = orderDate;
        this.status = status;
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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

    public void setOrderDate(Date order) {
        this.orderDate = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Order order : this.getOrder()) {
            total.add(BigDecimal.valueOf(order.getFood().getPrice() * (order.getOrderQuantity())));
            System.out.println("order " + order.getId());
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}