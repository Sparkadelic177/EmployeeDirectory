package com.example.employeedirectory.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    String uuid;
    String full_name;
    String phone_number;
    String email_address;
    String biography;
    String photo_url_small;
    String photo_url_large;
    String team;
    String employee_type;


    public Employees(JSONObject jsonObject) throws JSONException {
        this.uuid = EmployeeValidation.getuuid(jsonObject.getString("uuid"));
        this.full_name = EmployeeValidation.getFull_name(jsonObject.getString("full_name"));
        this.phone_number = EmployeeValidation.getPhone_number(jsonObject.getString("phone_number"));
        this.email_address = EmployeeValidation.getEmail_address(jsonObject.getString("email_address"));
        this.biography = EmployeeValidation.getBiography(jsonObject.getString("biography"));
        this.photo_url_small = EmployeeValidation.getPhoto_url_small(jsonObject.getString("photo_url_small"));
        this.photo_url_large = EmployeeValidation.getPhoto_url_large(jsonObject.getString("photo_url_large"));
        this.team = EmployeeValidation.getTeam(jsonObject.getString("team"));
        this.employee_type = EmployeeValidation.getEmployee_type(jsonObject.getString("employee_type"));
    }

    //Gets data from api call and creates and returns a list of type employees
    public static List<Employees> dataFromJSONArray(JSONArray employeesArray) throws JSONException {
        List<Employees> employees = new ArrayList<>();
        employeesArray = sortNames(employeesArray);
        for(int i = 0; i < employeesArray.length(); i++){
            employees.add(new Employees(employeesArray.getJSONObject(i)));
        }
        return employees;
    }

    //sorting by name
    public static JSONArray sortNames(JSONArray employeeArray) throws JSONException {
        String temp = "";
        for (int i = 0; i < employeeArray.length(); i++)
        {
            for (int j = i + 1; j < employeeArray.length(); j++)
            {
                if (employeeArray.getJSONObject(i).getString("full_name").compareTo(employeeArray.getJSONObject(j).getString("full_name"))>0)
                {
                    temp = employeeArray.getJSONObject(i).getString("full_name");
                    employeeArray.getJSONObject(i).put("full_name", employeeArray.getJSONObject(j).getString("full_name"));
                    employeeArray.getJSONObject(j).put("full_name", temp);
                }
            }
        }
        return employeeArray;
    }

    //getter functions for this class
    public String getUuid() {
        return uuid;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getBiography() {
        return biography;
    }

    public String getPhoto_url_small() {
        return photo_url_small;
    }

    public String getPhoto_url_large() {
        return photo_url_large;
    }

    public String getTeam() {
        return team;
    }

    public String getEmployee_type() {
        return employee_type;
    }
}
