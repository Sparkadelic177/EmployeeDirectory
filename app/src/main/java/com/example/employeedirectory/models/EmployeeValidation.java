package com.example.employeedirectory.models;

import org.json.JSONException;


public class EmployeeValidation {
    //required
    public static String getuuid(String uuid) throws JSONException {
        return nullChecker(uuid, "uuid");
    }
    //required
    public static String getFull_name(String full_name)throws JSONException {
        return nullChecker(full_name, "full_name");
    }

    public static String getPhone_number(String phone_number) {
        return defaultNullChecker(phone_number);
    }

    //required
    public static String getEmail_address(String email_address) throws JSONException {
        return nullChecker(email_address, "email_address");
    }

    public static String getBiography(String biography) {
       return defaultNullChecker(biography);
    }

    public static String getPhoto_url_small(String photo_url_small) {
        return defaultNullChecker(photo_url_small);
    }

    public static String getPhoto_url_large(String photo_url_large) {
        return defaultNullChecker(photo_url_large);
    }
    //required
    public static String getTeam(String team) throws JSONException {
        return nullChecker(team, "team");
    }
    //required
    public static String getEmployee_type(String employee_type) throws JSONException {
       return nullChecker(employee_type, "employee_type");
    }

    static String nullChecker(String value, String type) throws JSONException{
        if(value != null){
            return value;
        }
        throw new JSONException( type + " is not present");
    }

    static String defaultNullChecker(String value){
        if(value != null){
            return value;
        }
        return "";
    }
}
