package com.example.videos.service;

import com.example.videos.entity.Documentary;
import com.example.videos.repository.DocumentaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentaryService {

    private final DocumentaryRepository documentaryRepository;

    public List<Documentary> getAllDocumentaries() {
        return documentaryRepository.findAll();
    }

    public Documentary getDocumentaryById(Long id) {
        return documentaryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Documentary with ID " + id + " not found"
                ));
    }

    public Documentary createDocumentary(Documentary documentary) {
        return documentaryRepository.save(documentary);
    }

    @Transactional
    public Documentary updateDocumentary(Long id, Documentary updatedDocumentary) {
       Documentary documentary = documentaryRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                          "Documentary with ID " + id + " not found"
               ));


                    documentary.setTitle(updatedDocumentary.getTitle());
                    documentary.setDescription(updatedDocumentary.getDescription());
                    documentary.setDuration(updatedDocumentary.getDuration());
                    documentary.setGenre(updatedDocumentary.getGenre());
                    documentary.setUrl(updatedDocumentary.getUrl());
                    documentary.setImage(updatedDocumentary.getImage());
                    documentary.setSubject(updatedDocumentary.getSubject());
                    documentary.setNarrator(updatedDocumentary.getNarrator());
                    documentary.setReleaseYear(updatedDocumentary.getReleaseYear());

                    return documentaryRepository.save(documentary);
    }

    public void deleteDocumentary(Long id) {
        if (!documentaryRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Documentary with ID " + id + " not found"
            );
        }

        documentaryRepository.deleteById(id);
    }
}
