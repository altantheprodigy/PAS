package com.example.pas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {


    @GET("cnn/olahraga")
    Call<ResponseNewsSport> getNewsSport();

}
