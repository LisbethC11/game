package com.example.headsupdisplaygame.api3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceA {
    String API_ROUTE = "api.php?amount=10&category=27&difficulty=easy&type=multiple";
    @GET(API_ROUTE)
    Call<PostA>  getPost();

}
