package com.payment_system.payment_system.dto;

import com.payment_system.payment_system.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "O nome não pode ser nulo!")
        @NotBlank(message = "O nome não pode ser vazio!")
        @Size(min = 2, message = "Nome tem que ter mais que 2 caracteres!")
        String name,

        @NotNull(message = "O e-mail não pode ser nulo!")
        @NotBlank(message = "O e-mail não pode ser vazio!")
        @Email
        @NotNull String email,

        @NotNull(message = "A senha não pode ser nulo!")
        @NotBlank(message = "A senha não pode ser vazio!")
        @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres!")
        @NotNull String password
) {

    public User toModel() {
        return new User(name, email, password);
    }
}
