package com.example.headsupdisplaygame.api3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PostA {
    @SerializedName("results")
    @Expose
    private List<ResultA> results = null;

    public List<ResultA> getResults() {
        return results;
    }

    public void setResults(List<ResultA> results) {
        this.results = results;
    }
}
