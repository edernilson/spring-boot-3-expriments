package br.com.edernilson.sb3valueobjects.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;

import br.com.edernilson.sb3valueobjects.core.constant.ErrorConstant;
import br.com.edernilson.sb3valueobjects.integration.base.AbstractIntegrationTest;
import br.com.edernilson.sb3valueobjects.model.PersonEntity;
import br.com.edernilson.sb3valueobjects.model.PersonRepository;
import br.com.edernilson.sb3valueobjects.web.PersonCreateRequest;
import br.com.edernilson.sb3valueobjects.web.PersonResponse;
import jakarta.annotation.PostConstruct;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
class PersonAPIIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private PersonRepository personRepository;
    private PersonCreateRequest personCreateRequest;

    @PostConstruct
    public void init() {
        personCreateRequest = generatePersonCreateRequest();
    }

    @Test
    @DisplayName("Happy Path Test: save person and return person dto")
    void givenCorrectPersonCreateRequest_whenSavePerson_thenReturnPersonResponse() throws Exception {
        // when
        PersonResponse savedPersonResponse = performPostRequestExpectedSuccess(PERSON_API_ENDPOINT, personCreateRequest, PersonResponse.class);

        //then
        assertNotNull(savedPersonResponse);
        assertEquals(personCreateRequest.cpf(), savedPersonResponse.cpf());
        assertEquals(personCreateRequest.email(), savedPersonResponse.email());
        assertEquals(personCreateRequest.phone(), savedPersonResponse.phone());
    }

    @Test
    @DisplayName("Exception Test: person email must not be null case")
    void givenMissingEmail_whenSavePerson_thenThrowControllerException() throws Exception {
        // given
        PersonResponse personEmailNullResponse = generatePersonEmailNullResponse();

        // when
        ProblemDetail responseWithException = performPostRequestExpectedBadRequestError(PERSON_API_ENDPOINT, personEmailNullResponse, ProblemDetail.class);

        //then
        assertNotNull(responseWithException);
        assertEquals(ErrorConstant.ERROR_BAD_REQUEST_ERROR, responseWithException.getDetail());
    }

    @Test
    @DisplayName("Exception Test: person is already registered case")
    void givenRegisteredUserDTO_whenSaveUser_thenThrowControllerException() throws Exception {
        // given
        PersonEntity person = generatePerson();
        personRepository.save(person);
        // when
        ProblemDetail responseWithException = performPostRequestExpectedServerError(PERSON_API_ENDPOINT, personCreateRequest, ProblemDetail.class);

        //then
        assertNotNull(responseWithException);
        assertEquals(ErrorConstant.ERROR_PERSON_ALREADY_REGISTERED, responseWithException.getDetail());
    }


}