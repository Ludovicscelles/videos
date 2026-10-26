package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "film")
public class Film  extends Video {

    @NotBlank(message = "Director is mandatory")
    @Column(name = "director", nullable = false, length = 128)
    private String director;

    @NotNull(message = "Release year is mandatory")
    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;
}
