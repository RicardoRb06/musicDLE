package com.example.musicDLE.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Mapping("/api")
public class Controller {

    @PostMapping("/setArtist")
    public String printTest(){

    }
}
