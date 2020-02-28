package com.example.headsupdisplaygame.api3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultA {
    @SerializedName("correct_answer")
    @Expose
    private String correct_answer;

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }
}
