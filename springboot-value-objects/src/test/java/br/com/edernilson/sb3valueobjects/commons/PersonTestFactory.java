package br.com.edernilson.sb3valueobjects.commons;

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
public class PersonTestFactory {

    public static final String PERSON_API_ENDPOINT = "/api/person";
    public static final String MOCK_CPF = "53212312312";
    public static final String MOCK_MAIL = "eder.nilson@gmail.com";
    public static final String MOCK_PHONE = "85999999999";


    public PersonEntity generatePerson() {
        return new PersonEntity(
                new Cpf(MOCK_CPF),
                new Email(MOCK_MAIL),
                new Phone(MOCK_PHONE)
        );
    }

    public PersonEntity generatePersonWithDinamicEmail(String email) {
        return new PersonEntity(
                new Cpf(MOCK_CPF),
                new Email(email),
                new Phone(MOCK_PHONE)
        );
    }

    public PersonCreateRequest generatePersonCreateRequest() {
        return new PersonCreateRequest(
                MOCK_CPF,
                MOCK_MAIL,
                MOCK_PHONE
        );
    }

    public PersonCreateRequest generatePersonCreateRequestWithDinamicEmail(String email) {
        return new PersonCreateRequest(
                MOCK_CPF,
                email,
                MOCK_PHONE
        );
    }

    public PersonResponse generatePersonResponse() {
        return new PersonResponse(
                1L,
                MOCK_CPF,
                MOCK_MAIL,
                MOCK_PHONE
        );
    }


    public PersonResponse generatePersonResponseWithDinamicEmail(String email) {
        return new PersonResponse(
                1L,
                MOCK_CPF,
                email,
                MOCK_PHONE
        );
    }

    public PersonResponse generatePersonEmailNullResponse() {
        return new PersonResponse(
                1L,
                MOCK_CPF,
                null,
                "85999999999"
        );
    }

}