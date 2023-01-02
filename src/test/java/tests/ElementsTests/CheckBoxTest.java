package tests.ElementsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Elements.ElementsPage;


public class CheckBoxTest extends BaseTest {

    @Test
    public void testAllCheckBoxSelected() {
        ElementsPage checkBoxPage = openBaseURL()
                .clickElementsMenu()
                .openCheckBoxPage()
                .clickOnHomeCheckBox()
                .clickExpandAll();

        Assert.assertTrue(checkBoxPage.openCheckBoxPage().isAllCheckBoxSelected());
    }
}
