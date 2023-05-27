package com.example.pas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("cnn/olahraga")
    Call<ResponseNewsSport> getNewsSport();
}
