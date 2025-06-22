package br.com.edernilson.sb3valueobjects.integration;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.edernilson.sb3valueobjects.model.PersonEntity;
import br.com.edernilson.sb3valueobjects.model.PersonRepository;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Cpf;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Email;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 11/12/2024, quarta-feira
 */
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void givenUserEntity_whenSaveUser_thenUserIsPersisted() {
        // given
        PersonEntity person = new PersonEntity(
                new Cpf("12345678901"),
                new Email("eder.nilson@gmail.com"),
                new Phone("85999999999"));

        // when
        personRepository.save(person);

        // then
        Optional<PersonEntity> retrievedUser = personRepository.findById(1L);
        assertTrue(retrievedUser.isPresent());
        assertEquals("12345678901", retrievedUser.get().getCpf().getValue());
    }
}