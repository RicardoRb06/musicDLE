package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SelectGameDto;
import com.example.musicDLE.service.SelectGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SelectGameController {

    private SelectGameService selectGameService;

    public SelectGameController(SelectGameService selectGameService) {
        this.selectGameService = selectGameService;
    }

    @PostMapping("/searchArtist")
    public ResponseEntity<SelectGameDto<ArtistDto>> searchArtist(@RequestBody Map<String, String> name){
        SelectGameDto<ArtistDto> result = selectGameService.searchArtist(name.get("text"));

        return ResponseEntity.ok(result);
    }
}
