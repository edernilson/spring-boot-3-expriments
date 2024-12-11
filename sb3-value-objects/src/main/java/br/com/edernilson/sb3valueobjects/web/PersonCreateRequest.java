package br.com.edernilson.sb3valueobjects.web;

import br.com.edernilson.sb3valueobjects.model.valueobjects.Cpf;
import br.com.edernilson.sb3valueobjects.model.valueobjects.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
public record PersonCreateRequest(
        @NotBlank
        @Pattern(regexp = Cpf.VALID_CPF)
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = Phone.REGEX_VALID_PHONE)
        String phone
) {
}