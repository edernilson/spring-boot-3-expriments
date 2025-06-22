package br.com.edernilson.sb3valueobjects.model.valueobjects;

import java.util.regex.Pattern;

import lombok.Getter;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Getter
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private final String value;

    public Email(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.value = value.trim();
    }

    @Override
    public String toString() {
        return value;
    }
}