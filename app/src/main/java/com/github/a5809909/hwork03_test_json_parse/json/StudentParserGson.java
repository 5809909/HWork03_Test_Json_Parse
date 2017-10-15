package com.github.a5809909.hwork03_test_json_parse.json;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Date;

public class StudentParserGson implements IStudentParser {

    private final InputStream mInputStream;

    public StudentParserGson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IStudent parse() throws Exception {
        final JsonDeserializer<Date> date = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return json == null ? null : new Date(json.getAsLong());
            }

        };
        final Reader reader = new InputStreamReader(mInputStream);
        return new Gson().fromJson(reader, StudentGson.class);
    }

}
