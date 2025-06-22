package br.com.edernilson.distributedscheduling.web;

import java.io.Serial;
import java.io.Serializable;

import br.com.edernilson.distributedscheduling.models.OrderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public class OrderRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1754536678330787372L;

    private double price;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

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
        final StringBuffer sb = new StringBuffer("OrderRequest{");
        sb.append("price=").append(price);
        sb.append(", orderType=").append(orderType);
        sb.append('}');
        return sb.toString();
    }

}