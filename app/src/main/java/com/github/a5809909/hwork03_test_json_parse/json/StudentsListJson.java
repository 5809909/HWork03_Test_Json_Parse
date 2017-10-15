package com.github.a5809909.hwork03_test_json_parse.json;

import java.util.ArrayList;
import java.util.List;

public class StudentsListJson implements IStudentsList {

    private final List<StudentJson> mStudentsList;

    public StudentsListJson(final List<StudentJson> pStudentsList) {
        mStudentsList = pStudentsList;
    }

    @Override
    public List<IStudent> getStudentsList() {
        final List<IStudent> studentsList = new ArrayList<>();
        for (final StudentJson student :
                mStudentsList) {
            studentsList.add(student);

        }
        return studentsList;
    }
}
