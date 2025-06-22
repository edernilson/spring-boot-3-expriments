package br.com.edernilson.distributedscheduling.exceptions;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public class PaymentProcessorException extends RuntimeException {

    public PaymentProcessorException(String message) {
        super(message);
    }

    public PaymentProcessorException(String message, Throwable cause) {
        super(message, cause);
    }
}