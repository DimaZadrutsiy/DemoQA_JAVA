package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.InteractionsPage;
import testData.TestData;

import java.util.List;

public class InteractionsTest extends BaseTest {

    @Test(dataProviderClass = TestData.class, dataProvider = "InteractionsSubmenu")
    public void testInteractionsSubMenuLinksNavigateToCorrectPages(
            int index, String url, String title, String header) {

        InteractionsPage interactionsPage = openBaseURL()
                .clickInteractionsMenu();

        List<WebElement> submenus = interactionsPage
                .getInteractionsPageSubmenus();

        String actualUrl = interactionsPage
                .clickMenu(index, submenus)
                .getCurrentURL();

        Assert.assertEquals(actualUrl, url);
    }
}
