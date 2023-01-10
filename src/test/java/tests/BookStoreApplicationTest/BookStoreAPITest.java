package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BookStoreAPITest extends BaseTest {

    static HttpResponse<String> response;

    @Test
    public void test_API_HttpRequestResponse_IsbnNumber_BookDesigning_Evolvable_Web_APIs_With_ASP_NET() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://demoqa.com/BookStore/v1/Book?ISBN=9781449337711"))
                    .GET()
                    .build();

            response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.body());
        Assert.assertEquals(response.statusCode(), 200);

        JSONObject obj = new JSONObject(response.body());

        StringBuilder expectedIsbn = new StringBuilder();

        for (int i = 0; i < obj.length(); ) {
            expectedIsbn.append(obj.getString("isbn"));
            break;
        }

        String actualIsbn = openBaseURL()
                .clickBookAPI()
                .clickBookDesigning_Evolvable_Web_APIs_With_ASP_NET()
                .getIsbnNumber();

        Assert.assertTrue(actualIsbn.contains(expectedIsbn));
    }
}
