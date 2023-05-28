package com.example.pas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pas.databinding.ActivityDetailBinding;
import com.example.pas.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String newsId = intent.getStringExtra("news_id");

        getDetailNews(newsId);



    }
    private void getDetailNews(String newsId){
    ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
    Call<NewsItem> call= service.getDetailNews(newsId);
    call.enqueue(new Callback<NewsItem>() {
        @Override
        public void onResponse(Call<NewsItem> call, Response<NewsItem> response) {
            NewsItem news = response.body();
            setDataUi(news);
        }

        @Override
        public void onFailure(Call<NewsItem> call, Throwable t) {

        }
    });
    }
    private void setDataUi(NewsItem news) {
    binding.newsName.setText(news.getTitle());
    binding.newsDesc.setText(news.getDescription());


        String releaseDate = news.getPubDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy-mm-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(releaseDate);
            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            releaseDate = simpleDateFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        binding.newsReleaseDate.setText(getString(Integer.parseInt(releaseDate)));
        Picasso.get().load(news.getThumbnail()).into(binding.newsPoster);

    }


}