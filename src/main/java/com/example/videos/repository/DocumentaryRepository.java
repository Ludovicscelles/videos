package com.example.videos.repository;

import com.example.videos.entity.Documentary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentaryRepository extends JpaRepository <Documentary, Long> {
}
