package com.example.videos.service;

import com.example.videos.entity.Documentary;
import com.example.videos.repository.DocumentaryRepository;
import com.example.videos.dto.DocumentaryResponseDTO;
import com.example.videos.dto.DocumentaryRequestDTO;
import com.example.videos.dto.DocumentaryUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentaryService {

    private final DocumentaryRepository documentaryRepository;

    private DocumentaryResponseDTO toResponseDTO(Documentary documentary) {

        // Convert a Documentary entity to a DocumentaryResponseDTO
        DocumentaryResponseDTO dto = new DocumentaryResponseDTO();

        // Set the fields of the DTO based on the Documentary entity
        dto.setId(documentary.getId());
        dto.setTitle(documentary.getTitle());
        dto.setDescription(documentary.getDescription());
        dto.setDuration(documentary.getDuration());
        dto.setGenre(documentary.getGenre());
        dto.setUrl(documentary.getUrl());
        dto.setImage(documentary.getImage());
        dto.setUploadDate(documentary.getUploadDate());
        dto.setSubject(documentary.getSubject());
        dto.setNarrator(documentary.getNarrator());
        dto.setReleaseYear(documentary.getReleaseYear());

        return dto;
    }

    @Transactional(readOnly = true)
    public List<DocumentaryResponseDTO> getAllDocumentaries() {
        return documentaryRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public DocumentaryResponseDTO getDocumentaryById(Long id) {
        return documentaryRepository.findById(id)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Documentary with ID " + id + " not found"
                ));
    }

    @Transactional
    public DocumentaryResponseDTO createDocumentary(DocumentaryRequestDTO requestDocumentary) {
        Documentary newDocumentary = new Documentary();

        newDocumentary.setTitle(requestDocumentary.getTitle());
        newDocumentary.setDescription(requestDocumentary.getDescription());
        newDocumentary.setDuration(requestDocumentary.getDuration());
        newDocumentary.setGenre(requestDocumentary.getGenre());
        newDocumentary.setUrl(requestDocumentary.getUrl());
        newDocumentary.setImage(requestDocumentary.getImage());
        newDocumentary.setSubject(requestDocumentary.getSubject());
        newDocumentary.setNarrator(requestDocumentary.getNarrator());
        newDocumentary.setReleaseYear(requestDocumentary.getReleaseYear());

        Documentary savedDocumentary = documentaryRepository.save(newDocumentary);

        return toResponseDTO(savedDocumentary);
    }

    @Transactional
    public DocumentaryResponseDTO updateDocumentary(Long id, DocumentaryUpdateDTO updatedDocumentary) {
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

                    Documentary savedDocumentary = documentaryRepository.save(documentary);
                    return toResponseDTO(savedDocumentary);
    }

    @Transactional
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
