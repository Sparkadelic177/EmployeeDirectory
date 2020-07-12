package com.example.employeedirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.employeedirectory.models.HttpRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpRequest.getHttpRequest("https://s3.amazonaws.com/sq-mobile-interview/employees.json");
    }
}