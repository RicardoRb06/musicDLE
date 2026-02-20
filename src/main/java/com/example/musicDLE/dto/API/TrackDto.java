package com.example.musicDLE.dto.API;

import org.apache.tomcat.util.buf.UEncoder;

import java.net.URL;
import java.util.List;

public class TrackDto {
    private int id;
    private String title;
    private int duration;
    private URL preview;
    private List<ArtistDto> contributors;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public URL getPreview() {
        return preview;
    }

    public List<ArtistDto> getContributors() {
        return contributors;
    }
}
