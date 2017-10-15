package com.github.a5809909.hwork03_test_json_parse.http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
