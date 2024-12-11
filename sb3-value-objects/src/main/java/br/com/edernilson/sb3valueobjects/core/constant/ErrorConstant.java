package br.com.edernilson.sb3valueobjects.core.constant;

import br.com.edernilson.sb3valueobjects.core.exceptions.GenericAPIException;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 10/12/2024, terça-feira
 */
public class ErrorConstant {

    private ErrorConstant() throws GenericAPIException {
        throw new GenericAPIException(ERROR_ERROR_CONSTANT_UTILITY_CLASS);
    }

    public static final String ERROR_PERSON_NOT_FOUND = "Person not found.";
    public static final String ERROR_PERSON_CPF_MUST_NOT_BE_NULL = "Person CPF must not be null.";
    public static final String ERROR_PERSON_EMAIL_MUST_NOT_BE_NULL = "Person email must not be null.";
    public static final String ERROR_BAD_REQUEST_ERROR = "Invalid request content.";
    public static final String ERROR_PERSON_ALREADY_REGISTERED = "User is already registered.";
    public static final String ERROR_ERROR_CONSTANT_UTILITY_CLASS = "ErrorConstant class cannot be instantiated.";
}