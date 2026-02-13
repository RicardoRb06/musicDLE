package com.example.musicDLE.dto.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

public class ArtistDto {
    private int id;
    private String name;
    private URL picture;



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public URL getPicture() {
        return picture;
    }
}
