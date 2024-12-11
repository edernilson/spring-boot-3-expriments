package br.com.edernilson.distributedscheduling.factories;

import br.com.edernilson.distributedscheduling.exceptions.PaymentProcessorException;
import br.com.edernilson.distributedscheduling.models.OrderEntity;
import br.com.edernilson.distributedscheduling.models.OrderStatus;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public class CreditCardPaymentProcessor implements PaymentProcessor {

    CreditCardPaymentProcessor() {
    }

    @Override
    public OrderStatus execute(OrderEntity orderEntity) throws PaymentProcessorException {
        // Payment processing logic
        // Randomize true and false to simulate payment processing
        if (Math.random() < 0.5) {
            return OrderStatus.REJECTED;
        }
        return OrderStatus.APPROVED;
    }
}