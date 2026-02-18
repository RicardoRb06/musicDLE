package com.example.musicDLE.dto.API;

import java.net.URL;

public class AlbumDto {
    private int id;
    private String title;
    private URL cover;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public URL getCover() {
        return cover;
    }
}
