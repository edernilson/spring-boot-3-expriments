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
public class CpfConverter implements AttributeConverter<Cpf, String> {
    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        return nonNull(cpf) ? cpf.getValue() : null;
    }

    @Override
    public Cpf convertToEntityAttribute(String value) {
        return nonNull(value) ? new Cpf(value) : null;
    }
}