package com.example.videos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DocumentaryResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String genre;
    private String url;
    private String image;
    private LocalDateTime uploadDate;

    // Documentary-specific fields
    private String subject;
    private String narrator;
    private Integer releaseYear;
}
