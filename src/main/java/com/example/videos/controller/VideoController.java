package com.example.videos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @GetMapping("/videos")
    public String getVideos() {
        return "Bienvenue sur l'API de gestion des vidéos !";
    }
}
