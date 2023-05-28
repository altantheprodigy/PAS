package com.example.pas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("cnn/olahraga")
    Call<ResponseNewsSport> getNewsSport();

    @GET("cnn/{news_id}")
    Call<NewsItem> getDetailNews(@Path("news_id") String newsId);
}
