package com.example.videos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "videos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "description", nullable = true, length = 512)
    private String description;

    @Positive(message = "Duration must be a positive number")
    @Column(name="duration", nullable = true)
    private Integer duration; // Duration in minutes

    @NotBlank(message = "Genre is mandatory")
    @Column(name="genre", nullable = false, length = 64)
    private String genre;

    @NotBlank(message = "URL is mandatory")
    @Column(name = "url", nullable = false, length = 256)
    private String url;

    @NotBlank(message = "Image is mandatory")
    @Column(name = "image", nullable = false, length = 256)
    private String image;

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;

    @PrePersist
    public void prePersist() {
        if (uploadDate == null) {
            uploadDate = LocalDateTime.now();
        }
    }
}
