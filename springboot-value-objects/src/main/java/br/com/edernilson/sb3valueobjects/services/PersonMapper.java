package br.com.edernilson.sb3valueobjects.services;

import org.springframework.stereotype.Component;

import br.com.edernilson.sb3valueobjects.model.PersonEntity;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Cpf;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Email;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Phone;
import br.com.edernilson.sb3valueobjects.web.PersonCreateRequest;
import br.com.edernilson.sb3valueobjects.web.PersonResponse;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Component
public class PersonMapper {
    public PersonEntity toEntity(PersonCreateRequest request) {
        return new PersonEntity(
                new Cpf(request.cpf()),
                new Email(request.email()),
                new Phone(request.phone())
        );
    }

    public PersonResponse toResponse(PersonEntity personEntity) {
        return new PersonResponse(
                personEntity.getId(),
                personEntity.getCpf().getValue(),
                personEntity.getEmail().getValue(),
                personEntity.getPhone().getValue()
        );
    }
}