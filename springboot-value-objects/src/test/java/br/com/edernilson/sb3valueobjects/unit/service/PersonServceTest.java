package br.com.edernilson.sb3valueobjects.unit.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.edernilson.sb3valueobjects.commons.PersonTestFactory;
import br.com.edernilson.sb3valueobjects.core.exceptions.GenericAPIException;
import br.com.edernilson.sb3valueobjects.model.PersonEntity;
import br.com.edernilson.sb3valueobjects.model.PersonRepository;
import br.com.edernilson.sb3valueobjects.services.PersonMapper;
import br.com.edernilson.sb3valueobjects.services.PersonService;
import br.com.edernilson.sb3valueobjects.web.PersonCreateRequest;
import br.com.edernilson.sb3valueobjects.web.PersonResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 11/12/2024, quarta-feira
 */
@ExtendWith(MockitoExtension.class)
public class PersonServceTest extends PersonTestFactory {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    PersonMapper mapper;

    @ParameterizedTest
    @ValueSource(strings = {"eder.nilson@gmail.com", "lorin@gmail.com"})
    @DisplayName("Happy Path Test: save person use cases")
    void givenCorrectPersonRequest_whenSavePerson_thenReturnPersonResponse(String email) throws GenericAPIException {
        // given
        PersonCreateRequest personCreateRequest = generatePersonCreateRequestWithDinamicEmail(email);
        PersonEntity savedPerson = generatePersonWithDinamicEmail(email);
        PersonResponse personResponse = generatePersonResponseWithDinamicEmail(email);

        doReturn(savedPerson).when(personRepository).save(any());
        doReturn(savedPerson).when(mapper).toEntity(any());
        doReturn(personResponse).when(mapper).toResponse(any());

        // when
        PersonResponse savePerson = personService.createPerson(personCreateRequest);

        // then
        verify(personRepository, times(1)).findByEmailOrCpf(any(), any());
        verify(personRepository, times(1)).save(any());
        assertEquals(email, savePerson.email());
    }

}