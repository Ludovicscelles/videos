package com.example.videos.service;

import com.example.videos.repository.DocumentaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentaryService {

    private final DocumentaryRepository documentaryRepository;
}
