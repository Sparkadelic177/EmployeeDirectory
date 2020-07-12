package com.example.employeedirectory.models;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Headers;

public class HttpRequest {
    public static final String TAG = "HttpRequest";
    static JSONArray jsonArray = new JSONArray();

    //This method returns json array of the data
    public static JSONArray getHttpRequest(String url){

        //class used to call https requests
        AsyncHttpClient client = new AsyncHttpClient();


        client.get(url, new JsonHttpResponseHandler() {
            private Context context = this.context;

            @Override
            public void onSuccess(int statusCode, Headers headers, JsonHttpResponseHandler.JSON json) {
                Log.d(TAG, "onSucces");
                JSONObject jsonObject = json.jsonObject;
                try {
                    jsonArray = jsonObject.getJSONArray("employees");
                    Log.d(TAG, jsonArray.join(","));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, e.toString());
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });

        return jsonArray;
    }

}
