package com.github.a5809909.hwork03_test_json_parse.json;


import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StudentJson implements IStudent {

    private static final String mId = "_id";
    private static final String mAge = "age";
    private static final String mEyeColor = "eyeColor";
    private static final String mName = "name";
    private static final String mGender = "gender";
    private static final String mEmail = "email";
    private static final String mPhone = "phone";
    private static final String mAddress = "address";
    private static final String mRegistered = "registered";
    private final JSONObject mJSONObject;

    public StudentJson(final JSONObject pJSONObject) {
        mJSONObject = pJSONObject;
    }

    @Override
    public String getId() {
        return mJSONObject.optString(mId);
    }

    @Override
    public int getAge() {
        return mJSONObject.optInt(mAge);
    }

    @Override
    public String getEyeColor() {
        return mJSONObject.optString(mEyeColor);
    }

    @Override
    public String getName() {
        return mJSONObject.optString(mName);
    }

    @Override
    public String getGender() {
        return mJSONObject.optString(mGender);
    }

    @Override
    public String getEmail() {
        return mJSONObject.optString(mEmail);
    }

    @Override
    public String getPhone() {
        return mJSONObject.optString(mPhone);
    }

    @Override
    public String getAddress() {
        return mJSONObject.optString(mAddress);
    }

    @Override
    public String getRegisteredTime() throws ParseException {
        final long dateLong = mJSONObject.optLong(mRegistered);
        final Date date = new Date(dateLong);
        final DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss", Locale.ENGLISH);
        return dateFormat.format(date);
}
}
