package com.example.videos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import jakarta.validation.constraints.Past;

@Getter
@Setter
public class UserRequestDTO {

    @Size(max = 64, message = "Username must be at most 64 characters")
    private String username;

    @NotBlank(message = "First name is required")
    @Size(max = 48, message = "First name must be at most 48 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 48, message = "Last name must be at most 48 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(max = 128, message = "Email must be at most 128 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 12, message = "Password must be at least 12 characters")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be at most 20 characters")
    private String phone;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;
}
