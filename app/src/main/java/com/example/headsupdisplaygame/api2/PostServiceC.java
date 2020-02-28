package com.example.headsupdisplaygame.api2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceC {
    String API_ROUTE = "api.php?amount=10&category=26&difficulty=easy&type=multiple";
    @GET(API_ROUTE)
    Call<PostC>  getPost();

}
