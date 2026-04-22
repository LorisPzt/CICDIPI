package com.ipicicd.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "username is required")
        String username,
        @NotBlank(message = "password is required")
        String password,
        @NotBlank(message = "email is required")
        @Email(message = "email must be valid")
        String email
) {
}

