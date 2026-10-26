package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "serie")
public class Serie extends Video {

    @Column(name = "seasons", nullable = false)
    private Integer seasons;

    @Column(name = "episodes", nullable = false)
    private Integer episodes;

    @Column(name = "creator", nullable = false, length = 128)
    private String creator;

    @Column(name= "release_year", nullable = false)
    private Integer releaseYear;
}
