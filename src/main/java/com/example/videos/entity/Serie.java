package com.example.videos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "serie")
public class Serie extends Video {

    @NotNull(message = "Seasons is mandatory")
    @Column(name = "seasons", nullable = false)
    private Integer seasons;

    @NotNull(message = "Episodes is mandatory")
    @Column(name = "episodes", nullable = false)
    private Integer episodes;

    @NotBlank(message = "Creator is mandatory")
    @Column(name = "creator", nullable = false, length = 128)
    private String creator;

    @NotNull(message = "Release year is mandatory")
    @Column(name= "release_year", nullable = false)
    private Integer releaseYear;
}
