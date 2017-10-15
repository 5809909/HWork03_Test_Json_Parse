package com.github.a5809909.hwork03_test_json_parse;

import com.github.a5809909.hwork03_test_json_parse.http.IHttpClient;
import com.github.a5809909.hwork03_test_json_parse.json.IStudent;
import com.github.a5809909.hwork03_test_json_parse.json.StudentParserFactory;
import com.github.a5809909.hwork03_test_json_parse.mocks.Mocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class StudentParserTest {

    private static final String TAG = StudentParserTest.class.getSimpleName();

    private static final String EXPECTED_ID = "59dbe026b4637e74179f2121";
    private static final int EXPECTED_AGE = 36;
    private static final String EXPECTED_EYECOLOR = "brown";
    private static final String EXPECTED_NAME = "York Shepherd";
    private static final String EXPECTED_GENDER = "male";
    private static final String EXPECTED_EMAIL = "yorkshepherd@nixelt.com";
    private static final String EXPECTED_PHONE = "+1 (916) 436-2241";
    private static final String EXPECTED_ADDRESS = "857 Provost Street, Sedley, Kansas, 2506";
    private static final String EXPECTED_REGISTERED = "09 Oct 2017, 11:52:51";


    private InputStream mInputStream;
    private IHttpClient mIHttpClient;

    @Before
    public void setUp() {
        mIHttpClient = mock(IHttpClient.class);
    }


    @Test
    public void parseForJSON() throws Exception {
        mInputStream = Mocks.stream("student.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getUsersList");
        final StudentParserFactory studentParserFactory = new StudentParserFactory();
        final IStudent student = studentParserFactory.createParserJSON(response).parse();
        assertEquals(student.getId(), EXPECTED_ID);
        assertEquals(student.getAge(), EXPECTED_AGE);
        assertEquals(student.getEyeColor(), EXPECTED_EYECOLOR);
        assertEquals(student.getName(), EXPECTED_NAME);
        assertEquals(student.getGender(), EXPECTED_GENDER);
        assertEquals(student.getEmail(), EXPECTED_EMAIL);
        assertEquals(student.getPhone(), EXPECTED_PHONE);
        assertEquals(student.getAddress(), EXPECTED_ADDRESS);
        assertEquals(student.getRegisteredTime(), EXPECTED_REGISTERED);

    }

    @Test
    public void parseForGSON() throws Exception {
        mInputStream = Mocks.stream("student.json");
        when(mIHttpClient.request(Matchers.anyString())).thenReturn(mInputStream);
        final InputStream response = mIHttpClient.request("http://myBackend/getUsersList");
        final StudentParserFactory studentParserFactory = new StudentParserFactory();
        final IStudent student = studentParserFactory.createParserGSON(response).parse();
        assertEquals(student.getId(), EXPECTED_ID);
        assertEquals(student.getAge(), EXPECTED_AGE);
        assertEquals(student.getEyeColor(), EXPECTED_EYECOLOR);
        assertEquals(student.getName(), EXPECTED_NAME);
        assertEquals(student.getGender(), EXPECTED_GENDER);
        assertEquals(student.getEmail(), EXPECTED_EMAIL);
        assertEquals(student.getPhone(), EXPECTED_PHONE);
        assertEquals(student.getAddress(), EXPECTED_ADDRESS);
        assertEquals(student.getRegisteredTime(), EXPECTED_REGISTERED);
    }

}