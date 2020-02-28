package com.example.headsupdisplaygame.api2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PostC {
    @SerializedName("results")
    @Expose
    private List<ResultC> results = null;

    public List<ResultC> getResults() {
        return results;
    }

    public void setResults(List<ResultC> results) {
        this.results = results;
    }
}
