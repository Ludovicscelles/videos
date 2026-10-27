package com.example.videos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDTO {

    @Size(max = 6, message = "Number must be at most 6 characters")
    private String number;

    @NotBlank(message = "Street is required")
    @Size(max = 128, message = "Street must be at most 128 characters")
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 64, message = "City must be at most 64 characters")
    private String city;

    @NotBlank(message = "Zip code is required")
    @Size(max = 10, message = "Zip code must be at most 10 characters")
    private String zipCode;

    @NotBlank(message = "Country is required")
    @Size(max = 64, message = "Country must be at most 64 characters")
    private String country;
}
