package com.example.musicDLE.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class artistDto {
    private int id;
    private String name;
}
