package com.example.musicDLE.dto.API;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class DefaulsResponseDto<T> {
    public List<T> data;
}
