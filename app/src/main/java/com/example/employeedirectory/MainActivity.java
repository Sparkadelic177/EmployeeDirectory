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
    List<Employees> employees = new ArrayList<>();
    final String TAG = "MainActivity";
    final String goodUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees.json";
    final String malformedUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees_malformed.json";
    final String emptyUrl = "https://s3.amazonaws.com/sq-mobile-interview/employees_empty.json";
    final EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, employees);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvEmployee = findViewById(R.id.rvEmployeesLand);

        //set adapter to recyclerView
        rvEmployee.setAdapter(employeeAdapter);

        //set a layout manager on the recyclerView
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));


        httpGetRequest();
    }

    //Calls api and adds to employee list
    public void httpGetRequest(){
        //class used to call https requests
        AsyncHttpClient client = new AsyncHttpClient();

        //this method makes a get http request to the given URL
        client.get(emptyUrl, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Headers headers, JsonHttpResponseHandler.JSON json) {
                Log.d(TAG, "onSucces");
                JSONObject jsonObject = json.jsonObject;
                try {
                    employees.addAll(Employees.dataFromJSONArray(jsonObject.getJSONArray("employees")));
                    //show message if list is empty
                    if(employees.isEmpty()){
                        Toast.makeText(MainActivity.this, "Empty Employee Directory", Toast.LENGTH_LONG).show();
                    }
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