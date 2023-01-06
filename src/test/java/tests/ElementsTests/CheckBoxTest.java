package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.Elements.CheckBoxPage;
import pages.Elements.ElementsPage;

import java.util.Arrays;
import java.util.List;


public class CheckBoxTest extends BaseTest {

    @Test
    public void testAllCheckBoxSelected() {
        ElementsPage checkBoxPage = openBaseURL()
                .clickElementsMenu()
                .openCheckBoxPage()
                .clickOnHomeCheckBox()
                .clickExpandAll();

        Assert.assertTrue(checkBoxPage.openCheckBoxPage().isAllCheckBoxSelected());
        Assert.assertTrue(checkBoxPage.openCheckBoxPage().isAllCheckBoxDisplayed());
    }

    @Ignore
    @Test
    public void testOneElementIsUnchecked() {
        final List<String> expectedSelectedCheckboxes = Arrays.asList(
                "desktop", "notes", "commands",
                "documents", "workspace", "react", "angular", "veu", "office",
                "public", "private", "classified", "general", "wordFile"
        );

        List<String> actualSelectedCheckboxes = openBaseURL()
                .clickElementsMenu()
                .openCheckBoxPage()
                .clickOnHomeCheckBox()
                .clickExpandAll()
                .clickOnExcelFileCheckBox()
                .selectedResult();

        CheckBoxPage checkBoxPage = new CheckBoxPage(getDriver());

        Assert.assertFalse(checkBoxPage.isExcelFileCheckBoxSelected());
        Assert.assertEquals(actualSelectedCheckboxes,expectedSelectedCheckboxes);
    }
}
