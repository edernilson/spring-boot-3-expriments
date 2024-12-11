package br.com.edernilson.sb3valueobjects.model;

import br.com.edernilson.sb3valueobjects.model.valueobjects.Cpf;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Email;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Phone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    Cpf cpf;

    @Column(nullable = false)
    Email email;

    Phone phone;

    public PersonEntity(Cpf cpf, Email email, Phone phone) {
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }
}