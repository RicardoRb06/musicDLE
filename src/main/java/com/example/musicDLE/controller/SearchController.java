package com.example.musicDLE.controller;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SearchDto;
import com.example.musicDLE.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/Artist")
    public ResponseEntity<SearchDto<ArtistDto>> searchArtist(@RequestBody Map<String, String> name){
        SearchDto<ArtistDto> result = searchService.searchArtist(name.get("text"));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/Album")
    public ResponseEntity<SearchDto<AlbumDto>> searchAlbum(@RequestBody Map<String, String> name){
        SearchDto<ArtistDto> result = searchService.searchAlbum(name.get("text"));
        return ResponseEntity.ok(result);
    }
}
