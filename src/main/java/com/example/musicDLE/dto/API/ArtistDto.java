package com.example.musicDLE.dto.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

public class ArtistDto {
    private int id;
    private int nb_fan;
    private String name;
    private URL picture;
    private URL picture_xl;


    public int getNb_fan() {
        return nb_fan;
    }

    public URL getPicture_xl() {
        return picture_xl;
    }

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
