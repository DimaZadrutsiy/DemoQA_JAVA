package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void testUrl_HomePage() {
        String expectedResult = "https://demoqa.com/";

        openBaseURL();

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testH1Title_HomePage() {
        final String expectedTitle = "DEMOQA";

        openBaseURL();

        String actualTitle = getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
