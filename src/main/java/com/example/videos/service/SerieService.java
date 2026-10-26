package com.example.videos.service;

import com.example.videos.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SerieService {

  private final SerieRepository serieRepository;
}
