package com.github.a5809909.hwork03_test_json_parse.json;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class StudentsListParserGson implements IStudentsListParser {

    private InputStream mInputStream;

    public StudentsListParserGson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IStudentsList parse() throws Exception {
        final Reader reader = new InputStreamReader(mInputStream);
        final StudentGson[] result = new Gson().fromJson(reader, StudentGson[].class);
        return new StudentsListGson(Arrays.asList(result));
    }
}

