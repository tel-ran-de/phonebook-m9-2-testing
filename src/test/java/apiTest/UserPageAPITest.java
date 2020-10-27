package apiTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;

public class UserPageAPITest {
    CloseableHttpClient client;

    String baseURL = "http://localhost:8080/api/";
    HttpGet getRequest;  //request to server on url with user name
    String email = "yurchenkotest1@gmail.com";
    String user = "";
    String password = "yurchenkotest";
    HttpResponse response;  //answer from server
    String auth;
    HttpPost postRequest;
    HttpDelete deleteRequest;
    String token = "";

    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
    }

}
