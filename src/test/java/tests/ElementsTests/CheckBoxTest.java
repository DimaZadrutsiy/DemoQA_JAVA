package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
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

        Assert.assertTrue(getCheckBoxPage().isAllCheckBoxesSelected());
    }

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

        Assert.assertFalse(getCheckBoxPage().isExcelFileCheckBoxSelected());
        Assert.assertEquals(actualSelectedCheckboxes, expectedSelectedCheckboxes);
    }

    @Test
    public void test_ExpandListWithAllCheckBoxes() {
        final List<String> expectedTitleOfCheckboxes = Arrays.asList(
                "Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace", "React",
                "Angular", "Veu", "Office", "Public", "Private", "Classified", "General",
                "Downloads", "Word File.doc", "Excel File.doc"
        );
        final int expectedAmountCheckBoxTitle = 17;

        ElementsPage checkBoxPage = openBaseURL()
                .clickElementsMenu()
                .openCheckBoxPage()
                .clickExpandAll();

        Assert.assertEquals(getCheckBoxPage().getCheckBoxTitle(),expectedTitleOfCheckboxes);
        Assert.assertEquals(getCheckBoxPage().getCheckBoxTitleAmount(),expectedAmountCheckBoxTitle);
        Assert.assertTrue(getCheckBoxPage().isAllCheckBoxTitleDisplayed());
    }
}
