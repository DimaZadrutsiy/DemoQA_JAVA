package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.SelectablePage;
import testData.TestData;

import java.util.List;

public class SelectableTest extends BaseTest {

    @Test
    public void testNavigationSelectablePage() {
        final String expectedUrl = "https://demoqa.com/selectable";
        final String expectedTitle = "ToolsQA";
        final String expectedHeader = "Selectable";
        final String expectedBasedURL = "https://demoqa.com/";

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage();

        String actualUrl = selectablePage.getCurrentURL();
        String actualTitle = selectablePage.getTitle();
        String actualHeader = selectablePage.getH2Header();

        Assert.assertNotEquals(actualUrl, expectedBasedURL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "SelectableTabListData")
    public void testAllTabListElementsSelectable(
            int index, String className, String title, String text) {

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage();

        List<WebElement> tabList = selectablePage
                .clickDemoTabList()
                .getVerticalList();

        String actualClassName = selectablePage
                .getAttribute(tabList.get(index), "class");

        String actualContainerText = selectablePage
                .getText(tabList.get(index));

        String activatedClassName = selectablePage
                .clickMenu(index, tabList)
                .getAttribute(tabList.get(index), "class");

        Assert.assertEquals(actualClassName, className);
        Assert.assertEquals(actualContainerText, text);
        Assert.assertTrue(activatedClassName.contains("active"));
        Assert.assertEquals(selectablePage.getTitle(), title);
    }
}
