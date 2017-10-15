package com.github.a5809909.hwork03_test_json_parse.json;



import com.github.a5809909.hwork03_test_json_parse.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentsListParserJson implements IStudentsListParser {

    private final InputStream mInputStream;

    public StudentsListParserJson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IStudentsList parse() throws Exception {
        final JSONArray jsonArray = new JSONArray(IOUtils.toString(mInputStream));
        final List<StudentJson> studentsJsonList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject = jsonArray.getJSONObject(i);
            studentsJsonList.add(new StudentJson(jsonObject));
        }
        return new StudentsListJson(studentsJsonList);
    }
}
