package com.example.musicDLE.dto;

import java.util.List;

public class SearchDto<T> {

    private enum SearchStatus {
        NOT_FOUND,
        FOUND
    }

    private SearchStatus status;
    private List<T> results;

    public SearchDto() {}

    public SearchDto(List<T> results){
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
