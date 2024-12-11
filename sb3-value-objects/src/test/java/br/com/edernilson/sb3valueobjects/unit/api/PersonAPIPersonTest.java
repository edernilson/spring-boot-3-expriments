package br.com.edernilson.sb3valueobjects.unit.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.edernilson.sb3valueobjects.commons.PersonTestFactory;
import br.com.edernilson.sb3valueobjects.core.exceptions.GenericAPIException;
import br.com.edernilson.sb3valueobjects.services.PersonService;
import br.com.edernilson.sb3valueobjects.web.PersonAPI;
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
public class PersonAPIPersonTest extends PersonTestFactory {

    @InjectMocks
    private PersonAPI personAPI;
    @Mock
    private PersonService personService;

    @Test
    @DisplayName("Happy Path: save person use case")
    void givenCorrectPerson_whenSavePerson_thenReturnPersonEmail() throws GenericAPIException {
        // given
        PersonCreateRequest personCreateRequest = generatePersonCreateRequest();
        PersonResponse response = generatePersonResponse();

        doReturn(response).when(personService).createPerson(any());

        // when
        ResponseEntity<?> savedPersonEmail = personAPI.create(personCreateRequest);

        // then
        verify(personService, times(1)).createPerson(any());
        assertEquals(HttpStatus.CREATED, savedPersonEmail.getStatusCode());
    }

}