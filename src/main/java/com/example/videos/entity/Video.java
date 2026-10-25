package com.example.videos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "videos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "description", nullable = true, length = 512)
    private String description;

    @Column(name = "url", nullable = false, length = 256)
    private String url;

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;

    @PrePersist
    public void prePersist() {
        if (uploadDate == null) {
            uploadDate = LocalDateTime.now();
        }
    }
}
