package com.example.musicDLE.dto;

import com.example.musicDLE.dto.API.DefaulsResponseDto;

import java.util.List;

public class SelectGameDto<T> {

    private enum SearchStatus {
        NOT_FOUND,
        FOUND
    }

    private SearchStatus status;
    private List<T> results;

    public SelectGameDto() {}

    public SelectGameDto(List<T> results){
        this.results = (results == null) ? List.of() : results;

        if(results == null || this.results.isEmpty()) this.status = SearchStatus.NOT_FOUND;
        else this.status = SearchStatus.FOUND;
    }

    public SearchStatus getStatus() {
        return status;
    }

    public List<T> getResults() {
        return results;
    }
}
