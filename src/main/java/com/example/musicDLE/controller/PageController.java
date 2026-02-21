package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    private ArtistService artistService;

    public PageController(ArtistService artistService){this.artistService = artistService;}

    @GetMapping("/artist/{id}")
    public String artist(@PathVariable int id, Model model){
        ArtistDto artist = artistService.searchArtist(id);
        model.addAttribute("name", artist.getName());
        model.addAttribute("picture", artist.getPicture_xl());

        return "artistPage";
    }

    @@GetMapping("/artist/{id}/track")
    public String artistGame(@PathVariable int id, Model model){
        ArtistDto artist = artistService.searchArtist(id);
        model.addAttribute("name", artist.getName());
        model.addAttribute("picture", artist.getPicture_xl());

        return "defaultArtistGame";
    }
}
