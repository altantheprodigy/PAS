package com.example.pas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.pas.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rvNews.setLayoutManager(new LinearLayoutManager(this));

        getNewsSport();
    }
    private void getNewsSport(){
    ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
    Call<ResponseNewsSport> call = service.getNewsSport();
    call.enqueue(new Callback<ResponseNewsSport>() {
        @Override
        public void onResponse(Call<ResponseNewsSport> call, Response<ResponseNewsSport> response) {
            List<NewsItem> newsItems = response.body().getData().getPosts();

            NewsAdapter adapter = new NewsAdapter(newsItems);
            binding.rvNews.setAdapter(adapter);
        }


        @Override
        public void onFailure(Call<ResponseNewsSport> call, Throwable t) {

        }
    });
    }
}