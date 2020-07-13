package com.example.employeedirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.Headers;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.employeedirectory.adapters.EmployeeAdapter;
import com.example.employeedirectory.models.Employees;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String goodUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees.json";
    public static final String malformedUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees_malformed.json";
    public static final String emptyUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees_empty.json";
    List<Employees> employees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employees = new ArrayList<>();

        RecyclerView rvEmployee = findViewById(R.id.rvEmployeesLand);

        //create adapter
        final EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, employees);

        //set adapter to recyclerView
        rvEmployee.setAdapter(employeeAdapter);

        //set a layout manager on the recyclerView
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));

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
                    employeeAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, e.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "onFailure");
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                employees.clear();
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }

}