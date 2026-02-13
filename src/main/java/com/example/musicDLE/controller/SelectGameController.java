package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SelectGameDto;
import com.example.musicDLE.service.SelectGameService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SelectGameDto<ArtistDto>> startArtistGame(@RequestBody String name){
        SelectGameDto<ArtistDto> result = selectGameService.artistSelect(name);

        return ResponseEntity.ok(result);
    }
}
