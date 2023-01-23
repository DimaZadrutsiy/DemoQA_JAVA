package tests.InteractionTests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.InteractionsPage;
import testData.TestData;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
