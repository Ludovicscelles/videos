package com.example.videos.service;

import com.example.videos.entity.Serie;
import com.example.videos.repository.SerieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

  private final SerieRepository serieRepository;

  public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    public Serie getSerieById(Long id) {
        return serieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Serie with ID " + id + " not found"
                ));
    }

    public Serie createSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Transactional
    public Serie updateSerie(Long id, Serie updatedSerie) {
        Serie serie = serieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Serie with ID " + id + " not found"
                ));

        serie.setTitle(updatedSerie.getTitle());
        serie.setDescription(updatedSerie.getDescription());
        serie.setDuration(updatedSerie.getDuration());
        serie.setGenre(updatedSerie.getGenre());
        serie.setUrl(updatedSerie.getUrl());
        serie.setImage(updatedSerie.getImage());
        serie.setSeasons(updatedSerie.getSeasons());
        serie.setEpisodes(updatedSerie.getEpisodes());
        serie.setCreator(updatedSerie.getCreator());
        serie.setReleaseYear(updatedSerie.getReleaseYear());

        return serieRepository.save(serie);
    }

    public void deleteSerie(Long id) {
        if (!serieRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Serie with ID " + id + " not found"
            );
        }
        serieRepository.deleteById(id);
    }


}
