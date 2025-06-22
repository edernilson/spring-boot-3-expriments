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
public class PhoneConverter implements AttributeConverter<Phone, String> {
    @Override
    public String convertToDatabaseColumn(Phone phone) {
        return nonNull(phone) ? phone.getValue() : null;
    }

    @Override
    public Phone convertToEntityAttribute(String value) {
        return nonNull(value) ? new Phone(value) : null;
    }
}