package com.example.videos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FilmResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String genre;
    private String url;
    private String image;
    private LocalDateTime uploadDate;

    // Film-specific fields
    private String director;
    private Integer releaseYear;
}
