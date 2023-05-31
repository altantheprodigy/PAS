package com.example.pas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        // Mendapatkan intent yang memulai activity ini
        Intent intent = getIntent();

// Mengambil data yang dikirimkan melalui intent
        String nama = intent.getStringExtra("nama");
        String upload = intent.getStringExtra("upload");
        String thumbnail = intent.getStringExtra("thumbnail");
        String desc = intent.getStringExtra("desc");


        binding.newsName.setText(nama);
        binding.newsReleaseDate.setText(upload);
        binding.newsDesc.setText(desc);

// Menggunakan library Picasso untuk memuat gambar dari URL ke ImageView
        Picasso.get().load(thumbnail).into(binding.newsPoster);

    }
}