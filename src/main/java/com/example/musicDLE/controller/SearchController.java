package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SelectGameDto;
import com.example.musicDLE.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService selectGameService;

    public SearchController(SearchService selectGameService) {
        this.selectGameService = selectGameService;
    }

    @PostMapping("/Artist")
    public ResponseEntity<SelectGameDto<ArtistDto>> searchArtist(@RequestBody Map<String, String> name){
        SelectGameDto<ArtistDto> result = selectGameService.searchArtist(name.get("text"));
        return ResponseEntity.ok(result);
    }
}
