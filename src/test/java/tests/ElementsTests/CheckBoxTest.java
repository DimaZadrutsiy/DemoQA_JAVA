package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;

import java.util.Arrays;
import java.util.List;


public class CheckBoxTest extends BaseTest {

    @Test
    public void testAllCheckBoxSelected() throws InterruptedException {
        ElementsPage checkBoxPage = openBaseURL()
                .clickElementsMenu()
                .openCheckBoxPage()
                .clickOnHomeCheckBox()
                .clickExpandAll();

//        Assert.assertTrue(getCheckBoxPage().isHomeCheckBoxSelected());
//        Assert.assertTrue(getCheckBoxPage().isDesktopCheckBoxSelected());
//        Assert.assertTrue(getCheckBoxPage().isNotesCheckBoxSelected());
//        Assert.assertTrue(getCheckBoxPage().isCommandsCheckBoxSelected());
//        Assert.assertTrue(getCheckBoxPage().isDocumentsCheckBoxSelected());
//        Assert.assertTrue(getCheckBoxPage().isWorkspaceCheckBoxSelected());
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
}
