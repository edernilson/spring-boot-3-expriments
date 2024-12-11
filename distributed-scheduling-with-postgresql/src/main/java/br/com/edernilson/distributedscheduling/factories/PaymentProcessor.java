package br.com.edernilson.distributedscheduling.factories;

import br.com.edernilson.distributedscheduling.exceptions.PaymentProcessorException;
import br.com.edernilson.distributedscheduling.models.OrderEntity;
import br.com.edernilson.distributedscheduling.models.OrderStatus;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public interface PaymentProcessor {
    OrderStatus execute(OrderEntity orderEntity) throws PaymentProcessorException;
}