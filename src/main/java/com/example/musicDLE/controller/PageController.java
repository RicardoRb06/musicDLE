package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SearchDto;
import com.example.musicDLE.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    ArtistService artistService;

    @GetMapping("/artist/{id}")
    public String artista(@PathVariable int id){
        ArtistDto artist = artistService.searchArtist(id);
        System.out.println(artist);
        return "artistPage";
    }
}
