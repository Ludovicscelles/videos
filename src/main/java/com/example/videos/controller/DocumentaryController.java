package com.example.videos.controller;

import com.example.videos.entity.Documentary;
import com.example.videos.service.DocumentaryService;
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
    public List<Documentary> getAllDocumentaries() {
        return documentaryService.getAllDocumentaries();
    }

    @GetMapping("/{id}")
    public Documentary getDocumentaryById(@PathVariable Long id) {
        return documentaryService.getDocumentaryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Documentary createDocumentary(@RequestBody Documentary documentary) {
        return documentaryService.createDocumentary(documentary);
    }

   @PutMapping("/{id}")
    public Documentary updateDocumentary(
            @PathVariable Long id,
            @RequestBody Documentary updatedDocumentary) {

        return documentaryService.updateDocumentary(id, updatedDocumentary);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocumentary(@PathVariable Long id) {
        documentaryService.deleteDocumentary(id);
    }

}
