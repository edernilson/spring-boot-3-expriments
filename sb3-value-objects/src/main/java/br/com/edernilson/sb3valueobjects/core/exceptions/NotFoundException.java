package br.com.edernilson.sb3valueobjects.core.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Getter
@Setter
@ToString
public class NotFoundException extends RuntimeException {
    private final String errorMessage;

    public NotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}