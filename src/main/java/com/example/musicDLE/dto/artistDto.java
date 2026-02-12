package com.example.musicDLE.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class artistDto {
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
