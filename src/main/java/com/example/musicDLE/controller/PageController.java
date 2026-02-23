package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.service.ArtistService;
import com.example.musicDLE.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    private SearchService searchService;
    private ArtistService artistService;

    public PageController(SearchService searchService, ArtistService artistService){
        this.searchService = searchService;
        this.artistService = artistService;
    }

    @GetMapping("/artist/{id}")
    public String artist(@PathVariable int id, Model model){
        ArtistDto artist = searchService.searchArtistById(id);
        model.addAttribute("name", artist.getName());
        model.addAttribute("picture", artist.getPicture_xl());

        return "artistPage";
    }

    @GetMapping("/artist/{id}/randomMusic")
    public String artistGame(@PathVariable int id, Model model){
        ArtistDto artist = searchService.searchArtistById(id);
        model.addAttribute("name", artist.getName());
        model.addAttribute("picture", artist.getPicture_xl());

        return "defaultArtistGame";
    }
}
