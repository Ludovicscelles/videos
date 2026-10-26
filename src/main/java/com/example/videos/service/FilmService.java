package com.example.videos.service;

import com.example.videos.entity.Film;
import com.example.videos.repository.FilmRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Film with ID " + id + " not found"
                ));
    }

    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Transactional
    public Film updateFilm(Long id, Film updatedFilm) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Film with ID " + id + " not found"
                ));

        film.setTitle(updatedFilm.getTitle());
        film.setDescription(updatedFilm.getDescription());
        film.setDuration(updatedFilm.getDuration());
        film.setGenre(updatedFilm.getGenre());
        film.setUrl(updatedFilm.getUrl());
        film.setImage(updatedFilm.getImage());
        film.setDirector(updatedFilm.getDirector());
        film.setReleaseYear(updatedFilm.getReleaseYear());

        return filmRepository.save(film);

    }

    public void deleteFilm(Long id) {
        if (!filmRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Film with ID " + id + " not found"
            );
        }
        filmRepository.deleteById(id);
    }

}
