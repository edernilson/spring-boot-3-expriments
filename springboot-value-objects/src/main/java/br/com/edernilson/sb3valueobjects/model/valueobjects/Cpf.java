package br.com.edernilson.sb3valueobjects.model.valueobjects;

import java.util.regex.Pattern;

import lombok.Getter;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Getter
public class Cpf {
    public static final String VALID_CPF = "^\\d{11}$";
    private final Pattern CPF_PATTERN = Pattern.compile(VALID_CPF);

    private final String value;

    public Cpf(String value) {
        if (!isValidCPF(value)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.value = value;
    }

    public String getFormatted() {
        return value.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private boolean isValidCPF(String cpf) {
        return cpf != null && CPF_PATTERN.matcher(cpf.replaceAll("\\D", "")).matches();
    }

    @Override
    public String toString() {
        return getFormatted();
    }
}