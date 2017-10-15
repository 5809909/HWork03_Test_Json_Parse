package com.github.a5809909.hwork03_test_json_parse.json;



import java.io.InputStream;

public class StudentParserFactory {

    public IStudentParser createParserJSON(final InputStream pInputStream) {
        return new StudentParserJson(pInputStream);
    }

    public IStudentParser createParserGSON(final InputStream pInputStream) {
        return new StudentParserGson(pInputStream);
    }
}
