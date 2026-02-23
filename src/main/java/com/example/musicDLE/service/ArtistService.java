package com.example.musicDLE.service;

import com.example.musicDLE.dto.API.ArtistDto;
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

}
