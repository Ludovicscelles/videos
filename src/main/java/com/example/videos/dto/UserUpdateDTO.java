package com.example.videos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateDTO {

    @Size(max = 64, message = "Username must be at most 64 characters")
    private String username;

    @NotBlank
    @Size(max = 48, message = "First name must be at most 48 characters")
    private String firstName;

    @NotBlank
    @Size(max = 48, message = "Last name must be at most 48 characters")
    private String lastName;

    @NotBlank
    @Email(message = "Email should be valid")
    @Size(max = 128, message = "Email must be at most 128 characters")
    private String email;

    @NotBlank
    @Size(max = 20, message = "Phone number must be at most 20 characters")
    private String phone;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;

    @Valid
    private AddressRequestDTO address;

}
