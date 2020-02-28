package com.example.headsupdisplaygame.api4;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceG {
    String API_ROUTE = "api.php?amount=10&category=22&difficulty=easy&type=multiple";
    @GET(API_ROUTE)
    Call<PostG>  getPost();

}
