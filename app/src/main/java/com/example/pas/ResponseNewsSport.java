package com.example.pas;

import com.google.gson.annotations.SerializedName;

public class 	ResponseNewsSport{

	@SerializedName("data")
	private News data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private Object message;

	public News getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	public Object getMessage(){
		return message;
	}
}