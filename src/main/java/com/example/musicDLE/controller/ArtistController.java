package com.example.musicDLE.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @GetMapping("/{id}")
    public String artista(@PathVariable String id){
        System.out.println(id);
        return "artistPage";
    }
}
