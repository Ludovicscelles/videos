package com.example.videos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "documentary")
public class Documentary extends Video {

    @NotBlank(message = "Subject is mandatory")
    @Column(name = "subject", nullable = false, length = 128)
    private String subject;

    @Column(name = "narrator", nullable = true, length = 128)
    private String narrator;

    @NotNull(message = "Release year is mandatory")
    @Column(name= "release_year", nullable = false)
    private Integer releaseYear;
}
