package br.com.edernilson.sb3valueobjects.services;

import org.springframework.stereotype.Service;

import br.com.edernilson.sb3valueobjects.core.constant.ErrorConstant;
import br.com.edernilson.sb3valueobjects.core.exceptions.GenericAPIException;
import br.com.edernilson.sb3valueobjects.core.exceptions.NotFoundException;
import br.com.edernilson.sb3valueobjects.model.PersonEntity;
import br.com.edernilson.sb3valueobjects.model.PersonRepository;
import br.com.edernilson.sb3valueobjects.web.PersonCreateRequest;
import br.com.edernilson.sb3valueobjects.web.PersonResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {

    PersonMapper mapper;
    PersonRepository repository;

    public PersonResponse createPerson(PersonCreateRequest request) throws GenericAPIException {
        PersonEntity entity = mapper.toEntity(request);
        if (repository.findByEmailOrCpf(entity.getEmail(), entity.getCpf()).isPresent()) {
            throw new GenericAPIException(ErrorConstant.ERROR_PERSON_ALREADY_REGISTERED);
        };
        return mapper.toResponse(repository.save(entity));
    }

    public PersonResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException(ErrorConstant.ERROR_PERSON_NOT_FOUND));
    }
}