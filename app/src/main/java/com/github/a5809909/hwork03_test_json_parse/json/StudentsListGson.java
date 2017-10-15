package com.github.a5809909.hwork03_test_json_parse.json;



import java.util.ArrayList;
import java.util.List;

public class StudentsListGson implements IStudentsList {

    private List<StudentGson> mStudentsGSON;

    public StudentsListGson(final List<StudentGson> pStudentsGSON) {
        mStudentsGSON = pStudentsGSON;
    }

    @Override
    public List<IStudent> getStudentsList() {
        final List<IStudent> students = new ArrayList<>();
        for (final StudentGson student :
                mStudentsGSON) {
            students.add(student);
        }
        return students;
    }
}
