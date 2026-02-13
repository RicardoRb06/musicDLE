package com.example.musicDLE.controller;

import com.example.musicDLE.service.SelectGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SelectGameController {

    private SelectGameService selectGameService;

    public SelectGameController(SelectGameService selectGameService) {
        this.selectGameService = selectGameService;
    }

    @PostMapping("/setArtist")
    public ResponseEntity<String> startArtistGame(@RequestBody String name){
        return new ResponseEntity.ok(selectGameService.artistSelect(name));
    }
}
