package br.com.edernilson.distributedscheduling.jobs;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import br.com.edernilson.distributedscheduling.factories.PaymentProcessor;
import br.com.edernilson.distributedscheduling.factories.PaymentProcessorFactory;
import br.com.edernilson.distributedscheduling.models.OrderEntity;
import br.com.edernilson.distributedscheduling.models.OrderRepository;
import br.com.edernilson.distributedscheduling.models.OrderStatus;
import br.com.edernilson.distributedscheduling.models.PaymentStatusEntity;
import br.com.edernilson.distributedscheduling.models.PaymentStatusRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
@Service
public class PaymentServiceJob {

    private final PaymentStatusRepository paymentStatusRepository;
    private final OrderRepository orderRepository;
    private final TransactionTemplate transactionManager;
    private PaymentProcessor paymentProcessor;

    public PaymentServiceJob(PaymentStatusRepository paymentStatusRepository, OrderRepository orderRepository, TransactionTemplate transactionManager) {
        this.paymentStatusRepository = paymentStatusRepository;
        this.orderRepository = orderRepository;
        this.transactionManager = transactionManager;
    }

    @Scheduled(fixedRate = 60_000)
    public void execute() {
        boolean pending = true;
        while (pending) {
            // OrderEntity processing logic
            // Process remote payment
            // Payment processing logic
            pending = Boolean.TRUE.equals(transactionManager.execute(transaction -> {
                List<PaymentStatusEntity> paymentStatusEntities = paymentStatusRepository.findTop50ByOrderStatusOrderByCreatedAtDesc(OrderStatus.PENDING);
                if (paymentStatusEntities.isEmpty()) {
                    return false;
                }
                paymentStatusEntities.forEach(paymentStatusEntity -> {
                    // OrderEntity processing logic
                    OrderEntity orderEntity = orderRepository.findById(paymentStatusEntity.getOrderId()).get();

                    // Process remote payment
                    paymentProcessor = PaymentProcessorFactory.getPaymentProcessorFrom(orderEntity.getOrderType());
                    OrderStatus status = paymentProcessor.execute(orderEntity);

                    orderEntity.setOrderStatus(status);
                    orderRepository.save(orderEntity);

                    // Payment processing logic
                    paymentStatusEntity.setOrderStatus(status);
                    paymentStatusRepository.save(paymentStatusEntity);

                    System.out.println("Payment processed for orderEntity: " + orderEntity.getId() + " with status: " + status);
                });
                return true;
            }));
        }
    }
}