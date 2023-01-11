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

    @Test(priority = -3)
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

    @Test(dataProviderClass = TestData.class, dataProvider = "SelectableTabListData", priority = -2)
    public void testSelectAllTabsInList(
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

    @Test(dataProviderClass = TestData.class, dataProvider = "SelectableTabGridData",priority = -1)
    public void testSelectAllTabsInGrid(
            int index, String text, String colour, String colourSelect, String className, String classNameSelect) {
        List<WebElement> gridAll = new ArrayList<>();

        SelectablePage selectablePage = openBaseURL()
                .clickInteractionsMenu()
                .clickSelectablePage()
                .clickDemoTabGrid();

        gridAll.addAll(selectablePage.getGrid1());
        gridAll.addAll(selectablePage.getGrid2());
        gridAll.addAll(selectablePage.getGrid3());

        String actualColourBeforeSelect = selectablePage
                .clickDemoTabGrid()
                .getBackgroundColorInHEX(gridAll.get(index));

        String actualClassNameBeforeSelect = selectablePage
                .getAttribute(gridAll.get(index), "class");

        String actualElementText = selectablePage
                .getText(gridAll.get(index));

        String actualColourAfterSelect = selectablePage
                .clickDemoTabGrid()
                .clickMenu(index, gridAll)
                .getBackgroundColorInHEX(gridAll.get(index));

        String actualClassNameAfterSelect = selectablePage
                .getAttribute(gridAll.get(index), "class");

        Assert.assertEquals(actualClassNameBeforeSelect, className);
        Assert.assertEquals(actualColourBeforeSelect, colour);
        Assert.assertEquals(actualClassNameAfterSelect, classNameSelect);
        Assert.assertEquals(actualColourAfterSelect, colourSelect);
        Assert.assertEquals(actualElementText, text);
    }
}
