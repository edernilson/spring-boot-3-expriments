package br.com.edernilson.sb3valueobjects.core.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 10/12/2024, terça-feira
 */
@Getter
@Setter
@ToString
public class GenericAPIException extends Exception {

    private final String errorMessage;

    public GenericAPIException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}