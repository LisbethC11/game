package com.example.headsupdisplaygame;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    String API_ROUTE = "api.php?amount=5&category=20&difficulty=easy&type=multiple";
    @GET(API_ROUTE)
    Call<Post>  getPost();

}
