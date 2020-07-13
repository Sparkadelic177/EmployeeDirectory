package com.example.employeedirectory.models;

import org.json.JSONException;


public class EmployeeValidation {
    //required
    public static String getuuid(String uuid) throws JSONException {
        if(uuid != null){
            return uuid;
        }
        throw new JSONException("uuid is not present");
    }
    //required
    public static String getFull_name(String full_name)throws JSONException {
        if(full_name != null ){
            return full_name;
        }
        throw new JSONException("full_name is not present");
    }

    public static String getPhone_number(String phone_number) {
        if(phone_number != null){
            return phone_number;
        }
        return "";
    }

    //required
    public static String getEmail_address(String email_address) throws JSONException {
        if(email_address != null){
            return email_address;
        }
        throw new JSONException("email_address is not present");
    }

    public static String getBiography(String biography) {
        if(biography != null){
            return biography;
        }
        return "";
    }

    public static String getPhoto_url_small(String photo_url_small) {
        if(photo_url_small != null){
            return photo_url_small;
        }
        return "";
    }

    public static String getPhoto_url_large(String photo_url_large) {
        if(photo_url_large != null){
            return photo_url_large;
        }
        return "";
    }
    //required
    public static String getTeam(String team) throws JSONException {
        if(team  != null){
            return team;
        }
        throw new JSONException("Team is not present");
    }
    //required
    public static String getEmployee_type(String employee_type) throws JSONException {
        if(employee_type != null){
            return employee_type;
        }
        throw new JSONException("employee_type is not present");
    }
}
