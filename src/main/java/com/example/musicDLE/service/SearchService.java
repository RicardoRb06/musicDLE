package com.example.musicDLE.service;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.API.DefaulsResponseDto;
import com.example.musicDLE.dto.SelectGameDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SearchService {

    private final Gson gson = new Gson();

    public SelectGameDto<ArtistDto> searchArtist(String name){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.deezer.com/search/artist?q=" + name + "&limit=5")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Type responseType = new TypeToken<DefaulsResponseDto<ArtistDto>>(){}.getType();

            DefaulsResponseDto<ArtistDto> data = gson.fromJson(response.body(), responseType);
            return new SelectGameDto<ArtistDto>(data.data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new SelectGameDto<>(java.util.List.of());
        }
    }
}
