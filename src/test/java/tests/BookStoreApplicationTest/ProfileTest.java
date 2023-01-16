package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test
    public void testAddingBookToUserCollection() {
        final String userName = "TesterUserName";
        final String password = "Tester_1234!";
        final int expectedBooksListSize = 1;
        final String expectedBookName = "Git Pocket Guide";

        openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickProfileSubMenu()
                .clickLoginLink()
                .signInAsRegularUser(userName,password)
                .clickDeleteAllBooksButtonIfCollectionIsNotEmpty()
                .clickGoToStoreButton()
                .selectGitPocketGuideBook()
                .clickAddToYourCollectionButton()
                .clickProfileSubMenu();

        int actualSize = getProfilePage().getBooksListInUserCollectionSize();
        String actualBookName = getProfilePage().getFirstBookInList();

        Assert.assertEquals(actualSize, expectedBooksListSize);
        Assert.assertEquals(actualBookName, expectedBookName);
    }
}
