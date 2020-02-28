package com.example.headsupdisplaygame.api4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PostG {
    @SerializedName("results")
    @Expose
    private List<ResultG> results = null;

    public List<ResultG> getResults() {
        return results;
    }

    public void setResults(List<ResultG> results) {
        this.results = results;
    }
}
