package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "documentary")
public class Documentary extends Video {

    @Column(name = "subject", nullable = false, length = 128)
    private String subject;

    @Column(name = "narrator", nullable = true, length = 128)
    private String narrator;

    @Column(name= "release_year", nullable = false)
    private Integer releaseYear;
}
