package com.example.videos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class DocumentaryUpdateDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 128, message = "Title must be at most 128 characters")
    private String title;

    @Size(max = 512, message = "Description must be at most 512 characters")
    private String description;

    @Positive(message = "Duration must be a positive number")
    private Integer duration; // Duration in minutes

    @NotBlank(message = "Genre is mandatory")
    @Size(max = 64, message = "Genre must be at most 64 characters")
    private String genre;

    @NotBlank(message = "URL is mandatory")
    @Size(max = 256, message = "URL must be at most 256 characters")
    @URL(message = "URL must be a valid URL")
    private String url;

    @NotBlank(message = "Image URL is mandatory")
    @Size(max = 256, message = "Image URL must be at most 256 characters")
    @URL(message = "Image URL must be a valid URL")
    private String image;

    // Documentary-specific fields
    @NotBlank(message = "Subject is mandatory")
    @Size(max = 128, message = "Subject must be at most 128 characters")
    private String subject;

    @Size(max = 128, message = "Narrator must be at most 128 characters")
    private String narrator;

    @NotNull(message = "Release year is mandatory")
    @Min(value = 1888, message = "Release year must be no earlier than 1888")
    private Integer releaseYear;
}
