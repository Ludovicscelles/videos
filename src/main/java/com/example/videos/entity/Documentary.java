package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "documentary")
public class Documentary extends Video {

    @Column(name = "topic", nullable = false, length = 128)
    private String topic;

    @Column(name = "narrator", nullable = true, length = 128)
    private String narrator;

    @Column(name = "duration", nullable = false)
    private Integer duration; // Duration in minutes

    @Column(name= "release_year", nullable = false)
    private Integer releaseYear;
}
