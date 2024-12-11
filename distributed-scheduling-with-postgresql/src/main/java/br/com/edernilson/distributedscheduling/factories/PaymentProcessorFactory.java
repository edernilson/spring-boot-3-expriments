package br.com.edernilson.distributedscheduling.factories;

import br.com.edernilson.distributedscheduling.models.OrderType;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessorFrom(OrderType type) {
        return switch (type) {
            case CREDIT_CARD -> new CreditCardPaymentProcessor();
            default -> throw new IllegalArgumentException("Invalid order type");
        };
    }
}