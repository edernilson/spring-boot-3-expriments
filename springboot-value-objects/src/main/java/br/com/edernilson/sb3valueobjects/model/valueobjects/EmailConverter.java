package br.com.edernilson.sb3valueobjects.model.valueobjects;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import static java.util.Objects.nonNull;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email email) {
        return nonNull(email) ? email.getValue() : null;
    }

    @Override
    public Email convertToEntityAttribute(String value) {
        return nonNull(value) ? new Email(value) : null;
    }
}