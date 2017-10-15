package com.github.a5809909.hwork03_test_json_parse.json;

import com.github.a5809909.hwork03_test_json_parse.utils.IOUtils;
import org.json.JSONObject;
import java.io.InputStream;

public class StudentParserJson implements IStudentParser {

    private final InputStream mInputStream;

    public StudentParserJson(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public IStudent parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(IOUtils.toString(mInputStream));
        return new StudentJson(jsonObject);
    }
}
