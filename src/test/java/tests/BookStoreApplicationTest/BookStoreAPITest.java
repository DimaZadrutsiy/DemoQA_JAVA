package tests.BookStoreApplicationTest;


import api.ApiHelpers;
import api.model.Book;
import base.BaseTest;

import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import testData.TestData;
import utils.ProjectConstants;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class BookStoreAPITest extends BaseTest {

    static HttpResponse<String> response;
    final static String BASE_URI_API_BOOKS = ProjectConstants.BASE_URL + "BookStore/v1/Books";

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

    @Test
    public void test_API_HttpRequestResponse_TitleOfAllBooks() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://demoqa.com/BookStore/v1/Books"))
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
        JSONArray books = (JSONArray) obj.get("books");
        StringBuilder titleOfAllBooks = new StringBuilder();

        for (Object o : books) {
            titleOfAllBooks.append(((JSONObject) o).getString("title")
                    .concat(", "));
        }
        String expectedTitleOfAllBooks = titleOfAllBooks.toString().trim();
        expectedTitleOfAllBooks = expectedTitleOfAllBooks.substring(0,expectedTitleOfAllBooks.length()-1);

        List<String> listTitleOfAllBooks = openBaseURL()
                .clickBookStoreApplicationMenu()
                .getBooksList();

        String actualTitleOfAllBooks = ApiHelpers.getFormattedResult(listTitleOfAllBooks);

        Assert.assertEquals(actualTitleOfAllBooks, expectedTitleOfAllBooks);
    }

    @Test (dataProviderClass = TestData.class, dataProvider = "AllBooksList")
    public void testCheckGetBooksAPIRequest(int index,
                                            String expectedISBN, String expectedTitle, String expectedAuthor) {

        given()
                .baseUri(BASE_URI_API_BOOKS)
        .when()
                .get()
        .then()
                .statusCode(200)
                .and()
                .body("books.isbn[" + index + "]", equalTo(expectedISBN))
                .body("books.title[" + index + "]", equalTo(expectedTitle))
                .body("books.author[" + index + "]", equalTo(expectedAuthor));
    }

    @Test
    public void testCheckGetBooksAPIRequestV2() {
        //index of a book in a list on the Book Store Page and also index in json.file with all books
        final int index = 3;

        Book book = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickBookStoreApplicationSubMenu()
                .selectBook(index)
                .getPartialBookInfo();

        given()
                .baseUri(BASE_URI_API_BOOKS)
        .when()
                .get()
        .then()
                .statusCode(200)
                .and()
                .body("books.isbn[" + index + "]", equalTo(book.isbn))
                .body("books.title[" + index + "]", equalTo(book.title))
                .body("books.author[" + index + "]", equalTo(book.author));
    }

    @Test
    public void testFindBookByIsbnAPIRequest() {
        String isbn = "9781449331818";
        String endPoint = "https://demoqa.com/BookStore/v1/Book?ISBN="+ isbn;
        given().
                queryParams(Map.of("isbn", isbn)).
        when().
                get(endPoint).
        then().
                assertThat().
                statusCode(200).
                     contentType("application/json; charset=utf-8").
                     body("isbn", equalTo("9781449331818")).
                     body("title", equalTo( "Learning JavaScript Design Patterns")).
                     body("subTitle", equalTo("A JavaScript and jQuery Developer's Guide")).
                     body("author", equalTo("Addy Osmani")).
                     body("publisher", equalTo("O'Reilly Media"));
    }
}


