package com.example.employeedirectory;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Headers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.employeedirectory.models.Employees;
import com.example.employeedirectory.models.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String goodUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees.json";
    List<Employees> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employees = new ArrayList<>();

        //class used to call https requests
        AsyncHttpClient client = new AsyncHttpClient();

        //this method makes a get http request to the given URL
        client.get(goodUrl, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JsonHttpResponseHandler.JSON json) {
                Log.d(TAG, "onSucces");
                JSONObject jsonObject = json.jsonObject;
                try {
                    employees.addAll(Employees.dataFromJSONArray(jsonObject.getJSONArray("employees")));
                    Log.d("BeforeReturn", employees.toString());
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
    }
}