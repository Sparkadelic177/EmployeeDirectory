package com.example.employeedirectory.models;

import android.content.Context;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;

public class HttpRequest{
    public static final String TAG = "HttpRequest";
    JSONArray jsonArray = new JSONArray();

    //This method returns json array of the data
    public void getHttpRequest(String url){


    }

    public void setData(JSONArray data){
        jsonArray = data;
    }
    public JSONArray getData(){
       return jsonArray;
    }

}
