package com.example.musicDLE.service;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.SelectGameDto;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SelectGameService {

    public SelectGameDto<ArtistDto> artistSelect(String name){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.deezer.com/search/artist?q=" + name)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            SelectGameDto<ArtistDto> responseDto = new SelectGameDto<>(mapper.readValue(response.body, SelectGameDto<ArtistDto>.class););
            return responseDto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
