package com.example.musicDLE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/artist/{id}")
    public String artista(@PathVariable String id){
        return "artistPage";
    }
}
