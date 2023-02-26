package tests.BookStoreApplicationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    @Test
    public void testAddingBookToUserCollection() {

        final int expectedBooksListSize = 1;
        final String expectedBookName = "Git Pocket Guide";

        openBaseURL()
                .clickBookStoreApplicationMenu()
                .clickProfileSubMenu()
                .clickLoginLink()
                .signInAsRegularUser()
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
