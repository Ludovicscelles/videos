package com.example.videos.service;

import com.example.videos.entity.Film;
import com.example.videos.repository.FilmRepository;
import com.example.videos.dto.FilmResponseDTO;
import com.example.videos.dto.FilmRequestDTO;
import com.example.videos.dto.FilmUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    private FilmResponseDTO toResponseDTO(Film film) {

        FilmResponseDTO dto = new FilmResponseDTO();

        dto.setId(film.getId());
        dto.setTitle(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setDuration(film.getDuration());
        dto.setGenre(film.getGenre());
        dto.setUrl(film.getUrl());
        dto.setImage(film.getImage());
        dto.setUploadDate(film.getUploadDate());
        dto.setDirector(film.getDirector());
        dto.setReleaseYear(film.getReleaseYear());

        return dto;
    }

    @Transactional(readOnly = true)
    public List<FilmResponseDTO> getAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public FilmResponseDTO getFilmById(Long id) {
        return filmRepository.findById(id)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Film with ID " + id + " not found"
                ));
    }

    @Transactional
    public FilmResponseDTO createFilm(FilmRequestDTO requestFilm) {

        Film film = new Film();

        film.setTitle(requestFilm.getTitle());
        film.setDescription(requestFilm.getDescription());
        film.setDuration(requestFilm.getDuration());
        film.setGenre(requestFilm.getGenre());
        film.setUrl(requestFilm.getUrl());
        film.setImage(requestFilm.getImage());
        film.setDirector(requestFilm.getDirector());
        film.setReleaseYear(requestFilm.getReleaseYear());

        Film savedFilm = filmRepository.save(film);

        return toResponseDTO(savedFilm);
    }

    @Transactional
    public FilmResponseDTO updateFilm(Long id, FilmUpdateDTO updatedFilm) {
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

        Film savedFilm = filmRepository.save(film);

        return toResponseDTO(savedFilm);

    }

    @Transactional
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
