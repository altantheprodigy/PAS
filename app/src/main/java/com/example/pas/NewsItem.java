package com.example.pas;

import com.google.gson.annotations.SerializedName;

public class NewsItem {

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("pubDate")
	private String pubDate;

	public String getThumbnail(){
		return thumbnail;
	}

	public String getLink(){
		return link;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public String getPubDate(){
		return pubDate;
	}
}