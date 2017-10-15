package com.github.a5809909.hwork03_test_json_parse.json;

import org.json.JSONException;

import java.text.ParseException;
import java.util.Date;

public interface IStudent {

    String getId();

    int getAge();

    String getEyeColor();

    String getName();

    String getGender();

    String getEmail();

    String getPhone();

    String getAddress();

    String getRegisteredTime() throws ParseException;

}
