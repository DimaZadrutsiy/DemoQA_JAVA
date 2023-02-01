package tests.FormsTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Forms.FormsPage;

import static utils.ProjectConstants.*;

public class FormsTest extends BaseTest {

    @Test
    public void testNavigationToFormPage() {
        FormsPage formsPage = openBaseURL().clickFormsMenu();

        String actualUrl = formsPage.getCurrentURL();
        String actualTitle = formsPage.getTitle();
        String actualHeader = formsPage.getH2Header();

        Assert.assertNotEquals(actualUrl, BASE_URL);
        Assert.assertEquals(actualUrl, FORMS_URL);
        Assert.assertEquals(actualTitle, TITLE);
        Assert.assertEquals(actualHeader, FORMS_HEADER);
    }
}
