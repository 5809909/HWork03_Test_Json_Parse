package com.github.a5809909.hwork03_test_json_parse;

import com.github.a5809909.hwork03_test_json_parse.http.IHttpClient;
import com.github.a5809909.hwork03_test_json_parse.json.IStudent;
import com.github.a5809909.hwork03_test_json_parse.json.IStudentsList;
import com.github.a5809909.hwork03_test_json_parse.json.StudentsListParserFactory;
import com.github.a5809909.hwork03_test_json_parse.mocks.Mocks;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)

public class StudentsListParserTest {

    private static final String EXPECTED_ID = "59dbe02684a66bbe143b20d1";
    private static final int EXPECTED_AGE = 23;
    private static final String EXPECTED_EYECOLOR = "blue";
    private static final String EXPECTED_NAME = "Shelia Chang";
    private static final String EXPECTED_GENDER = "female";
    private static final String EXPECTED_EMAIL = "sheliachang@soprano.com";
    private static final String EXPECTED_PHONE = "+1 (968) 481-3312";
    private static final String EXPECTED_ADDRESS = "309 Ryder Street, Davenport, Maryland, 9562";
    private static final String EXPECTED_REGISTERED = "09 Oct 2017, 11:52:51";

    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseFromJSON() throws Exception {
        mInputStream = Mocks.stream("student_list.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getUsersList");
        final StudentsListParserFactory studentsListParserFactory = new StudentsListParserFactory();
        final IStudentsList students = studentsListParserFactory.createListParserForJSON(response).parse();
        final List<IStudent> studentsList = students.getStudentsList();
        assertEquals(studentsList.get(0).getId(), EXPECTED_ID);
        assertEquals(studentsList.get(0).getAge(), EXPECTED_AGE);
        assertEquals(studentsList.get(0).getEyeColor(), EXPECTED_EYECOLOR);
        assertEquals(studentsList.get(0).getName(), EXPECTED_NAME);
        assertEquals(studentsList.get(0).getGender(), EXPECTED_GENDER);
        assertEquals(studentsList.get(0).getEmail(), EXPECTED_EMAIL);
        assertEquals(studentsList.get(0).getPhone(), EXPECTED_PHONE);
        assertEquals(studentsList.get(0).getAddress(), EXPECTED_ADDRESS);
        assertEquals(studentsList.get(0).getRegisteredTime(), EXPECTED_REGISTERED);

    }

    @Test
    public void parseFromGSON() throws Exception {
        mInputStream = Mocks.stream("student_list.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getUsersList");
        final StudentsListParserFactory studentsListParserFactory = new StudentsListParserFactory();
        final IStudentsList students = studentsListParserFactory.createListParserForGSON(response).parse();
        final List<IStudent> studentsList = students.getStudentsList();
        assertEquals(studentsList.get(0).getId(), EXPECTED_ID);
        assertEquals(studentsList.get(0).getAge(), EXPECTED_AGE);
        assertEquals(studentsList.get(0).getEyeColor(), EXPECTED_EYECOLOR);
        assertEquals(studentsList.get(0).getName(), EXPECTED_NAME);
        assertEquals(studentsList.get(0).getGender(), EXPECTED_GENDER);
        assertEquals(studentsList.get(0).getEmail(), EXPECTED_EMAIL);
        assertEquals(studentsList.get(0).getPhone(), EXPECTED_PHONE);
        assertEquals(studentsList.get(0).getAddress(), EXPECTED_ADDRESS);
        assertEquals(studentsList.get(0).getRegisteredTime(), EXPECTED_REGISTERED);

    }
}