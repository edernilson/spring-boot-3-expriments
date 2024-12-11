package br.com.edernilson.sb3valueobjects.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edernilson.sb3valueobjects.model.valueobjects.Cpf;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Email;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query("SELECT p FROM PersonEntity p WHERE p.email = :email OR p.cpf = :cpf")
    Optional<PersonEntity> findByEmailOrCpf(Email email, Cpf cpf);

}