package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "film")
public class Film  extends Video {

    @Column(name = "duration", nullable = false)
    private Integer duration; // Duration in minutes

    @Column(name = "director", nullable = false, length = 128)
    private String director;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;
}
