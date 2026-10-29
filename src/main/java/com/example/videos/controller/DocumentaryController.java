package com.example.videos.controller;

import com.example.videos.service.DocumentaryService;
import com.example.videos.dto.DocumentaryResponseDTO;
import com.example.videos.dto.DocumentaryRequestDTO;
import com.example.videos.dto.DocumentaryUpdateDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/api/videos/documentaries")
@RequiredArgsConstructor
public class DocumentaryController {

    private final DocumentaryService documentaryService;

    @GetMapping
    public List<DocumentaryResponseDTO> getAllDocumentaries() {
        return documentaryService.getAllDocumentaries();
    }

    @GetMapping("/{id}")
    public DocumentaryResponseDTO getDocumentaryById(@PathVariable Long id) {
        return documentaryService.getDocumentaryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentaryResponseDTO createDocumentary(@Valid @RequestBody DocumentaryRequestDTO documentary) {
        return documentaryService.createDocumentary(documentary);
    }

   @PutMapping("/{id}")
    public DocumentaryResponseDTO updateDocumentary(
            @PathVariable Long id,
            @Valid @RequestBody DocumentaryUpdateDTO updatedDocumentary) {

        return documentaryService.updateDocumentary(id, updatedDocumentary);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocumentary(@PathVariable Long id) {
        documentaryService.deleteDocumentary(id);
    }

}
