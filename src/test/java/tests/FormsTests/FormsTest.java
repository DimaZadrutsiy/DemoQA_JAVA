package tests.FormsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Forms.FormsPage;

public class FormsTest extends BaseTest {

    @Test
    public void testNavigationToFormPage() {
        final String expectedUrl = "https://demoqa.com/forms";
        final String expectedTitle = "ToolsQA";
        final String expectedHeader = "Forms";
        final String expectedBasedURL = "https://demoqa.com/";

        FormsPage formsPage = openBaseURL().clickFormsMenu();

        String actualUrl = formsPage.getCurrentURL();
        String actualTitle = formsPage.getTitle();
        String actualHeader = formsPage.getH2Header();

        Assert.assertNotEquals(actualUrl, expectedBasedURL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
