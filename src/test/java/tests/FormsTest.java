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

        FormsPage formsPage = openBaseURL().clickFormsMenu();

        String actualUrl = formsPage.getCurrentURL();
        String actualTitle = formsPage.getTitle();

        Assert.assertNotEquals(actualUrl, BASE_URL);
        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
