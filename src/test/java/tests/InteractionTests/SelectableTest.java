package tests.InteractionTests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Interactions.SelectablePage;
import testData.TestData;

import java.util.ArrayList;
import java.util.List;

public class SelectableTest extends BaseTest {

    @Test
    public void testNavigationSelectablePage() {
        final String expectedUrl = "https://demoqa.com/selectable";
        final String expectedTitle = "DEMOQA";
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
    public void testSelectAllTabsInList(
            int index, String expectedClassName, String expectedTitle, String expectedText) {

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage();

        List<WebElement> list = selectablePage
                .clickDemoTabList()
                .getVerticalList();

        String actualClassName = selectablePage
                .getAttribute(list.get(index), "class");

        String actualContainerText = selectablePage
                .getText(list.get(index));

        String activatedClassName = selectablePage
                .clickMenu(index, list)
                .getAttribute(list.get(index), "class");

        Assert.assertEquals(actualClassName, expectedClassName);
        Assert.assertTrue(actualContainerText.contentEquals(expectedText));
        Assert.assertTrue(activatedClassName.contains("active"));
        Assert.assertEquals(selectablePage.getTitle(), expectedTitle);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "SelectableTabGridData")
    public void testSelectAllTabsInGrid( int index, String expectedText, String expectedColour,
            String expectedSelectedColour, String expectedClassName, String expectedSelectedClassName) {

        List<WebElement> grid = new ArrayList<>();

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage()
                .clickDemoTabGrid();

        grid.addAll(selectablePage.getGrid1());
        grid.addAll(selectablePage.getGrid2());
        grid.addAll(selectablePage.getGrid3());

        String actualColourBeforeSelect = selectablePage
                .clickDemoTabGrid()
                .getBackgroundColourInHEX(grid.get(index));

        String actualClassNameBeforeSelect = selectablePage
                .getAttribute(grid.get(index), "class");

        String actualColourAfterSelect = selectablePage
                .clickDemoTabGrid()
                .clickMenu(index, grid)
                .getBackgroundColourInHEX(grid.get(index));

        String actualClassNameAfterSelect = selectablePage
                .getAttribute(grid.get(index), "class");

        Assert.assertEquals(actualClassNameBeforeSelect, expectedClassName);
        Assert.assertEquals(actualColourBeforeSelect, expectedColour);
        Assert.assertEquals(actualClassNameAfterSelect,expectedSelectedClassName);
        Assert.assertEquals(actualColourAfterSelect, expectedSelectedColour);
        Assert.assertTrue(selectablePage.getText(grid.get(index)).contentEquals(expectedText));
    }
}
