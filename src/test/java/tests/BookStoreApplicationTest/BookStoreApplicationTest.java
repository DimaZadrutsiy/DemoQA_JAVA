package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStoreApplication.BookStorePage;

import java.util.Arrays;
import java.util.List;

public class BookStoreApplicationTest extends BaseTest {

    @Test
    public void testNavigationToBookStorePage() {
        final String expectedURL = "https://demoqa.com/books";
        final String expectedTitle = "ToolsQA";
        final String expectedHeader = "Book Store";

        BookStorePage bookStorePage = openBaseURL()
                .clickBookStoreApplicationMenu();

        //вот тут вместо создания переменной bookStorePage можно брать геттеры страницы
        String actualURL = bookStorePage.getCurrentURL();
        String actualTitle = bookStorePage.getTitle();
        String actualHeader = bookStorePage.getH2MainHeaderText();

        Assert.assertNotEquals(actualURL, BASE_URL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
    @Test
    public void testBookStorePageSubMenuList() {
        final List<String> expectedSubMenuHeaders = Arrays.asList(
                "Login", "Book Store", "Profile", "Book Store API"
        );
        final int expectedSubMenusSize = 4  ;

        List <String> actualSubMenuHeaders = openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickBookStoreApplicationSubMenu()
                .getBookStorePageSubMenuHeaders();

        int actualSubMenusSize = actualSubMenuHeaders.size();

        Assert.assertEquals(actualSubMenuHeaders, expectedSubMenuHeaders);
        Assert.assertEquals(actualSubMenusSize, expectedSubMenusSize);
    }
}
