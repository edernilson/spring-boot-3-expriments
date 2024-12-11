package br.com.edernilson.sb3valueobjects.model.valueobjects;

import lombok.Getter;

import static java.util.Objects.isNull;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Getter
public class Phone {

    /**
     * accepted phone formats regex.
     * <br>
     * 1199999999, 119999-9999, 11 99999-99999, 11 9999999999
     */
    public static final String REGEX_VALID_PHONE = "^([0-9]{2})\\s?(\\d{4,5})-?(\\d{4})$";
    private final String value;

    public Phone(String value) {
        if (isNull(value) || !isValidPhone(value)) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
        this.value = value.replaceAll("\\D", ""); // Remove formatação
    }

    public String getFormatted() {
        return value.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }

    private boolean isValidPhone(String telefone) {
        return telefone != null && telefone.matches("\\d{10,11}");
    }

    @Override
    public String toString() {
        return getFormatted();
    }
}