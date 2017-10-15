package com.github.a5809909.hwork03_test_json_parse.json;


import java.io.InputStream;

public class StudentsListParserFactory {

    public IStudentsListParser createListParserForJSON(final InputStream pInputStream) {
        return new StudentsListParserJson(pInputStream);
    }

    public IStudentsListParser createListParserForGSON(final InputStream pInputStream) {
        return new StudentsListParserGson(pInputStream);
    }
}
