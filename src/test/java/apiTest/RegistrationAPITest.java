package apiTest;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.http.HttpResponse;
import utils.Constants;
import utils.FunctionalTest;

import java.io.IOException;
import java.net.URL;

public class RegistrationAPITest extends FunctionalTest {

    CloseableHttpClient client;
    HttpPost postRequest;
    URL object = new URL(Constants.REGISTRATION_API_URL);
    HttpResponse response;
    HttpGet getRequest;

    public RegistrationAPITest() throws IOException {
    }

    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
        postRequest = new HttpPost(Constants.REGISTRATION_API_URL);
        postRequest.addHeader("Content-Type", "application/json");
    }

    @After
    public void getResponse() { }

}


