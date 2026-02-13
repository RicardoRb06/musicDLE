package com.example.musicDLE.dto;

import java.util.List;

public class SelectGameDto<T> {

    private enum SearchStatus {
        NOT_FOUND,
        MULTIPLE_RESULTS,
        SINGLE_RESULT
    }

    private SearchStatus status;
    private List<T> results;

    public SelectGameDto(List<T> results){
        this.results = results;

        if(results.isEmpty() || results == null) this.status = SearchStatus.NOT_FOUND;
        if(results.size() == 1) this.status = SearchStatus.SINGLE_RESULT;
        if(results.size() > 1) this.status = SearchStatus.MULTIPLE_RESULTS;
    }

    public SearchStatus getStatus() {
        return status;
    }

    public List<T> getResults() {
        return results;
    }
}
