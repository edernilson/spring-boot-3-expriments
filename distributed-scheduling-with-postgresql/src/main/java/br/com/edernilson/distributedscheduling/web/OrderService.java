package br.com.edernilson.distributedscheduling.web;

import org.springframework.stereotype.Service;

import br.com.edernilson.distributedscheduling.models.OrderStatus;
import br.com.edernilson.distributedscheduling.models.OrderEntity;
import br.com.edernilson.distributedscheduling.models.OrderRepository;
import br.com.edernilson.distributedscheduling.models.PaymentStatusEntity;
import br.com.edernilson.distributedscheduling.models.PaymentStatusRepository;
import jakarta.transaction.Transactional;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentStatusRepository paymentStatusRepository;

    public OrderService(OrderRepository orderRepository, PaymentStatusRepository paymentStatusRepository) {
        this.orderRepository = orderRepository;
        this.paymentStatusRepository = paymentStatusRepository;
    }

    @Transactional
    public OrderEntity create(OrderRequest request) {
        OrderEntity orderEntity = new OrderEntity(request.getPrice(), request.getOrderType(), OrderStatus.PENDING);
        OrderEntity orderEntitySaved = orderRepository.save(orderEntity);
        paymentStatusRepository.save(new PaymentStatusEntity(orderEntitySaved.getId(), OrderStatus.PENDING));
        return orderEntitySaved;
    }
}