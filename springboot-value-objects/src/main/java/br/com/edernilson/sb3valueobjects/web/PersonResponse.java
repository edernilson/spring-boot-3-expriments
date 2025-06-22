package br.com.edernilson.sb3valueobjects.web;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
public record PersonResponse(
        Long id,
        String cpf,
        String email,
        String phone
) {
}