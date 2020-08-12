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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cart_order", joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", unique = true)})
    List<Order> order;

    public Cart() {

    }

    public Cart(Long id, BigDecimal subtotal, Date date, String status) {
        this.id = id;
        orderDate = date;
        this.status = status;
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
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
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
                ", orderList=" + order +
                '}';
    }
}