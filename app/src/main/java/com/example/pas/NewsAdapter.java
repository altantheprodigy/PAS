package com.example.pas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsItem> localDataSet;

    public NewsAdapter(List<NewsItem> dataSet){
        localDataSet = dataSet;
    }
    @Override
    // nyambungin ke layoutnya
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNewsTitle, tvNewsDesc,  tvNewsPub;
        private final ImageView imgNewsPoster;
        public ViewHolder(View view) {
            super(view);
            // nyambungin data movie ke layout menggunakan id
            tvNewsDesc = view.findViewById(R.id.news_desc);
            tvNewsTitle = view.findViewById(R.id.news_name);
            tvNewsPub = view.findViewById(R.id.news_release_date);
            imgNewsPoster = view.findViewById(R.id.news_poster);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        NewsItem news = localDataSet.get(position);
        String judul = news.getTitle();
        String desc = news.getDescription();
        String pubDate = news.getPubDate();



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy-mm-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(pubDate);
            simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
            pubDate = simpleDateFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        viewHolder.tvNewsDesc.setText(desc);
        viewHolder.tvNewsTitle.setText(judul);
        viewHolder.tvNewsPub.setText(pubDate);
        Picasso.get().load(news.getThumbnail()).into(viewHolder.imgNewsPoster);


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}



