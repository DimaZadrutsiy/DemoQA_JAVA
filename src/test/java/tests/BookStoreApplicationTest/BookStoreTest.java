package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookStoreApplication.BookStorePage;
import testData.TestData;

import java.util.Arrays;
import java.util.List;

public class BookStoreTest extends BaseTest {

    @Test
    public void testNavigationToBookStorePage() {
        final String expectedURL = "https://demoqa.com/books";
        final String expectedTitle = "DEMOQA";
        final String expectedHeader = "Book Store";
        final String expectedBasedURL = "https://demoqa.com/";

        BookStorePage bookStorePage = openBaseURL()
                .clickBookStoreApplicationMenu();

        //вот тут вместо создания переменной bookStorePage можно брать геттеры страницы
        String actualURL = bookStorePage.getCurrentURL();
        String actualTitle = bookStorePage.getTitle();
        String actualHeader = bookStorePage.getH2MainHeaderText();

        Assert.assertNotEquals(actualURL, expectedBasedURL);
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

    @Test
    public void testBooksListChecking() {
        final List<String> expectedBooksList = Arrays.asList(
                "Git Pocket Guide", "Learning JavaScript Design Patterns",
                "Designing Evolvable Web APIs with ASP.NET", "Speaking JavaScript",
                "You Don't Know JS", "Programming JavaScript Applications", "Eloquent JavaScript, Second Edition",
                "Understanding ECMAScript 6"
        );
        final int expectedBooksListSize = 8  ;

        List <String> actualBooksList = openBaseURL()
                .clickBookStoreApplicationMenu()
                .getBooksList();

        int actualSubMenusSize = actualBooksList.size();

        Assert.assertEquals(actualBooksList, expectedBooksList);
        Assert.assertEquals(actualSubMenusSize, expectedBooksListSize);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "DifferentBooksSearching")
    public void testSearchingBooksResult(int index, String searchingBook,
                                         String expectedFirstBookFound, int expectedNumberOfBooksFound) {

        BookStorePage newBookStorePage = openBaseURL()
                .clickBookStoreApplicationMenu()
                .inputBookName(searchingBook);

        String actualFirstBookFound = newBookStorePage.getFirstBookInList();
        int actualNumberOfBooksFound = newBookStorePage.getBooksListSize();

        Assert.assertEquals(actualFirstBookFound, expectedFirstBookFound);
        Assert.assertEquals(actualNumberOfBooksFound, expectedNumberOfBooksFound);
    }
}
