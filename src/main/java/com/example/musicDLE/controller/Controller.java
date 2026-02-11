package com.example.musicDLE.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public record TextDTO(String text) {}

    @PostMapping("/api")
    public String printTest(@RequestBody TextDTO dto){
        System.out.println(dto.text());
        return "ok";
    }
}
