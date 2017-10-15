package com.github.a5809909.hwork03_test_json_parse.json;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentGson implements IStudent {

    @SerializedName("_id")
    private String mId;
    @SerializedName("age")
    private int mAge;
    @SerializedName("eyeColor")
    private String mEyeColor;
    @SerializedName("name")
    private String mName;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("registered")
    private Long mRegistered;

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public int getAge() {
        return mAge;
    }

    @Override
    public String getEyeColor() {
        return mEyeColor;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getGender() {
        return mGender;
    }

    @Override
    public String getEmail() {
        return mEmail;
    }

    @Override
    public String getPhone() {
        return mPhone;
    }

    @Override
    public String getAddress() {
        return mAddress;
    }


 @Override
    public String getRegisteredTime() {
	 Date date = new Date(mRegistered);
     DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss", Locale.ENGLISH);
     return dateFormat.format(date);

    }

}

