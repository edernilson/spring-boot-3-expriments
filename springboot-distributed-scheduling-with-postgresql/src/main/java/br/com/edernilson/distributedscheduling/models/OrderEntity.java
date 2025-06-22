package br.com.edernilson.distributedscheduling.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @CreationTimestamp
    private Instant createdAt;

    private double price;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    public OrderEntity() {
    }

    public OrderEntity(double price, OrderType orderType, OrderStatus orderStatus) {
        this.price = price;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderEntity{");
        sb.append("id=").append(id);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", price=").append(price);
        sb.append(", orderType=").append(orderType);
        sb.append('}');
        return sb.toString();
    }
}