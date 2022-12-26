package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;

public class FormsTest extends BaseTest {

    @Test
    public void testNavigationToFormPage() {
        String expectedUrl = "https://demoqa.com/forms";
        String expectedTitle = "ToolsQA";
        String expectedHeader = "Forms";

        FormsPage formsPage = openBaseURL().clickFormsMenu();

        String actualUrl = formsPage.getCurrentURL();
        String actualTitle = formsPage.getTitle();
        String actualHeader = formsPage.getH2LogoHeaderText();

        Assert.assertNotEquals(actualUrl, BASE_URL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualHeader, expectedHeader);
    }
}
