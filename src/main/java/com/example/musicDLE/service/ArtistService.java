package com.example.musicDLE.service;

import com.example.musicDLE.dto.API.ArtistDto;
import com.example.musicDLE.dto.API.DefaulsResponseDto;
import com.example.musicDLE.dto.SearchDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ArtistService {

    private final Gson gson = new Gson();
    private final HttpClient client = HttpClient.newHttpClient();

    public ArtistDto searchArtist(int id){
        try{
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.deezer.com/artist/" + id)).build();
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            Type responseType = new TypeToken<ArtistDto>(){}.getType();

            return gson.fromJson(response.body(), responseType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArtistDto();
        }
    }
}
